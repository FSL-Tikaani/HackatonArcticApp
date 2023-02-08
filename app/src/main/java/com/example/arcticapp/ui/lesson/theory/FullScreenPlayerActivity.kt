package com.example.arcticapp.ui.lesson.theory

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.example.arcticapp.ui.lesson.LessonActivity
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.ActivityFullScreenPlayerBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.common.collect.ImmutableList

class FullScreenPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenPlayerBinding
    //player
    private lateinit var player: ExoPlayer
    private lateinit var playerView: StyledPlayerView
    private lateinit var progressBar: ProgressBar

    private var timeStart: Long = 0
    private var fileName: Int = R.raw.video1
    private var lessonID: String = "lesson1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenPlayerBinding.inflate(layoutInflater)

        progressBar = binding.progressBar

        timeStart = intent.getLongExtra("timeStart", 0)
        fileName = intent.getIntExtra("fileName", R.raw.video1)
        lessonID = intent.getStringExtra("lessonID").toString()

        setupPlayer(timeStart)
        addMP4Files(fileName)

        setContentView(binding.root)
    }
    private fun setupPlayer(timeStart: Long) {
        player = ExoPlayer.Builder(this).build()
        playerView = binding.videoView
        playerView.setFullscreenButtonClickListener {
            player.stop()
            player.release()
            onBackPressed()
        }

        player.seekTo(timeStart)

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

    private fun addMP4Files(fileName: Int) {
        val uriVideo = Uri.parse(
            "android.resource://$packageName/$fileName"
        )
        val mediaItem = MediaItem.fromUri(uriVideo)

        val newItems: List<MediaItem> = ImmutableList.of(
            mediaItem
        )

        player.addMediaItems(newItems)
        player.prepare()
    }

    override fun onStop() {
        super.onStop()
        player.stop()
        player.release()
    }

    override fun onResume() {
        super.onResume()
        setupPlayer(timeStart)
        addMP4Files(fileName)
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            player.stop()
            player.release()
        }catch (ex: Exception){
            Log.d("ErrorPlayer", ex.stackTraceToString())
        }
        Log.d("player", "onSaveInstanceState: " + player.currentPosition)
    }
}