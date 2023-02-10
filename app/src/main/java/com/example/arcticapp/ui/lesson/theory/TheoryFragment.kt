package com.example.arcticapp.ui.lesson.theory


import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.arcticapp.data.downloader.AndroidDownloader
import com.example.arcticapp.data.downloader.DownloadCompletedReceiver
import com.example.arcticapp.data.models.EducationItemModel
import com.example.arcticapp.ui.dialogs.QuestionDialogFragment
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.FragmentTheoryBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView
import java.io.File


class TheoryFragment(
    private val lessonID: String
) : Fragment() {
    private lateinit var binding: FragmentTheoryBinding
    private lateinit var viewModel: TheoryViewModel
    private lateinit var lessonModel: EducationItemModel
    //videoPlayer
    private lateinit var player: ExoPlayer
    private lateinit var playerView: StyledPlayerView
    private lateinit var progressBar: ProgressBar
    private var lastTimePlayer: Long = 0


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTheoryBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[TheoryViewModel::class.java]

        viewModel.theory.observe(viewLifecycleOwner) { theory ->
            lessonModel = theory
            binding.tvDescription.text = theory.description
            progressBar = binding.progressBar
            setupPlayer()
            addMP4Files(lastTimePlayer)
        }
        viewModel.loadTheory(lessonID)

        //init videoPlayer
        //status
        binding.tvStatusVideo.setOnClickListener {
            if(!isLocalVideoExists(lessonModel.fileVideoName)){
                val downloader = AndroidDownloader(requireContext(), lessonModel.fileVideoName)
                downloader.downloadFile(lessonModel.urlVideo)
            }else{
                Toast.makeText(requireContext(), "Видео уже загружено", Toast.LENGTH_SHORT).show()
            }
        }

        binding.imgQuestionDownloading.setOnClickListener {
            val myQuestionDialog = QuestionDialogFragment(R.string.answer_text)
            val manager = childFragmentManager
            myQuestionDialog.show(manager, "")
        }

        return binding.root
    }

    private fun setupPlayer() {
        player = ExoPlayer.Builder(requireContext()).build()
        playerView = binding.videoView
        playerView.setFullscreenButtonClickListener {
            Log.d("player.currentPosition", player.currentPosition.toString())
            val activity = Intent(context, FullScreenPlayerActivity::class.java)
            activity.putExtra("fileName", lessonModel.fileVideoName)
            activity.putExtra("urlVideo", lessonModel.urlVideo)
            activity.putExtra("lastTimePlayer", lastTimePlayer)
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

    private fun addMP4Files(lastTimePlayer: Long){
        try {
            val mediaItem:MediaItem

            if(isLocalVideoExists(lessonModel.fileVideoName)){
                val path = binding.root.context.getExternalFilesDir(null)
                val videoPath = File(path, lessonModel.fileVideoName)

                mediaItem = MediaItem.fromUri(videoPath.toUri())
            }else{
                val uriVideo = Uri.parse(
                    lessonModel.urlVideo
                )
                mediaItem = MediaItem.fromUri(uriVideo)
            }

            if(player.mediaItemCount == 0){
                player.addMediaItem(mediaItem)
            }else{
                player.removeMediaItems(0, player.mediaItemCount)
                player.addMediaItem(mediaItem)
            }

            player.seekTo(lastTimePlayer)
            player.prepare()
            player.playWhenReady = false
        } catch (e: Exception) {}

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
        addMP4Files(lastTimePlayer)
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
            Log.d("ErrorPla yer", ex.stackTraceToString())
        }
        Log.d("player", "onSaveInstanceState: " + player.currentPosition)
    }

    private fun isLocalVideoExists(fileName: String): Boolean{
        val path = binding.root.context.getExternalFilesDir(null)
        val newFolder = File(path, fileName)

        if(newFolder.exists()){
            binding.tvStatusVideo.text = "Видео может воспроизводится без Интернета"
            return true
        }else{
            binding.tvStatusVideo.text = "Видео воспроизводится через Интернет"
            return false
        }
    }
}