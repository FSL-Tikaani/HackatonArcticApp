package com.example.arcticapp.ui.lesson.theory

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.models.LessonTheory
import com.example.arcticapp.ui.adapters.WordsAdapter
import com.example.arcticappfinal.databinding.FragmentTheoryBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.common.collect.ImmutableList

class TheoryFragment(
    private val lessonID: String
) : Fragment() {
    private lateinit var binding: FragmentTheoryBinding
    private lateinit var viewModel: TheoryViewModel
    private var lessonModel: LessonTheory = LessonTheory()
    //videoPlayer
    private lateinit var player: ExoPlayer
    private lateinit var playerView: StyledPlayerView
    private lateinit var progressBar: ProgressBar
    private var lastTimePlayer: Long = 0
    //recycler view
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WordsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTheoryBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[TheoryViewModel::class.java]

        viewModel.loadTheory(lessonID)

        //init recycler view
        recyclerView = binding.recyclerViewSmallVocabulary
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = WordsAdapter()

        viewModel.theory.observe(viewLifecycleOwner) { theory ->
            lessonModel = theory
            binding.textView.text = theory.nameLesson
            binding.tvDescription.text = theory.descriptionLesson

            adapter.setDataList(theory.arrWordsInVideo)
        }

        recyclerView.adapter = adapter
        //init videoPlayer
        progressBar = binding.progressBar
        setupPlayer()
        addMP4Files(lessonModel.srcVideo, lastTimePlayer)

        return binding.root
    }

    private fun setupPlayer() {
        player = ExoPlayer.Builder(requireContext()).build()
        playerView = binding.videoView
        playerView.setFullscreenButtonClickListener {
            Log.d("player.currentPosition", player.currentPosition.toString())
            val activity = Intent(context, FullScreenPlayerActivity::class.java)
            activity.putExtra("timeStart", player.currentPosition)
            activity.putExtra("fileName", lessonModel.srcVideo)
            activity.putExtra("lessonID", lessonID)
            startActivity(activity)
        }

        playerView.player = player
        player.addListener(object : Player.Listener{
            override fun onPlaybackStateChanged(state: Int) {
                when (state) {
                    Player.STATE_BUFFERING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                    Player.STATE_READY -> {
                        progressBar.visibility = View.INVISIBLE
                    }
                }
            }
        })
    }

    private fun addMP4Files(video: Int, lastTimePlayer: Long){
        val uriVideo = Uri.parse(
            "android.resource://" + activity?.packageName + "/" + video)
        val mediaItem = MediaItem.fromUri(uriVideo)

        val newItems: List<MediaItem> = ImmutableList.of(
            mediaItem
        )
        player.seekTo(lastTimePlayer)
        player.addMediaItems(newItems)
        player.prepare()
    }

    override fun onStop() {
        super.onStop()
        player.stop()
        player.release()
        Log.d("theory_fragment", "onStop()")
    }

    override fun onResume() {
        super.onResume()
        setupPlayer()
        addMP4Files(lessonModel.srcVideo, lastTimePlayer)
        Log.d("theory_fragment", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        player.stop()
        lastTimePlayer = player.currentPosition
        Log.d("theory_fragment", "onPause()")
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            player.stop()
            player.release()
            Log.d("theory_fragment", "onDesctroy()")
        }catch (ex: Exception){
            Log.d("ErrorPlayer", ex.stackTraceToString())
        }
        Log.d("player", "onSaveInstanceState: " + player.currentPosition)
    }
}