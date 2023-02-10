package com.example.arcticapp.ui.lesson.theory

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.core.net.toUri
import com.example.arcticapp.ui.lesson.LessonActivity
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.ActivityFullScreenPlayerBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.common.collect.ImmutableList
import java.io.File

class FullScreenPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenPlayerBinding
    //player
    private lateinit var player: ExoPlayer
    private lateinit var playerView: StyledPlayerView
    private lateinit var progressBar: ProgressBar

    private var timeStart: Long = 0
    private var fileName: String = ""
    private var urlVideo: String = ""
    private var lastTimePlayer: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenPlayerBinding.inflate(layoutInflater)

        progressBar = binding.progressBar

        timeStart = intent.getLongExtra("timeStart", 0)

        fileName = intent.getStringExtra("fileName")!!
        urlVideo = intent.getStringExtra("urlVideo")!!
        lastTimePlayer = intent.getLongExtra("lastTimePlayer", 0)

        setupPlayer()
        addMP4Files(fileName, urlVideo, lastTimePlayer)

        setContentView(binding.root)
    }

    private fun setupPlayer() {
        player = ExoPlayer.Builder(this).build()
        playerView = binding.videoView
        playerView.setFullscreenButtonClickListener {
            player.stop()
            player.release()
            onBackPressed()
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

    private fun addMP4Files(fileName: String, urlVideo: String, lastTimePlayer: Long) {
        val mediaItem:MediaItem

        if(isLocalVideoExists(fileName)){
            val path = binding.root.context.getExternalFilesDir(null)
            val videoPath = File(path, fileName)

            mediaItem = MediaItem.fromUri(videoPath.toUri())
        }else{
            val uriVideo = Uri.parse(urlVideo)
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
        player.playWhenReady = false;
    }

    override fun onStop() {
        super.onStop()
        player.stop()
        player.release()
    }

    override fun onResume() {
        super.onResume()
        setupPlayer()
        addMP4Files(fileName, urlVideo, lastTimePlayer)
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

    private fun isLocalVideoExists(fileName: String): Boolean{
        val path = binding.root.context.getExternalFilesDir(null)
        val newFolder = File(path, fileName)

        return newFolder.exists()
    }
}