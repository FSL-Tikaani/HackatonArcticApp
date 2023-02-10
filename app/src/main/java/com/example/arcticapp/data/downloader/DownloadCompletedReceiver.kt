package com.example.arcticapp.data.downloader

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

class DownloadCompletedReceiver: BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == "android.intent.action.DOWNLOAD_COMPLETE"){
            val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1L)
            if(id != -1L){
                println("Download with ID $id finished!")
            }
        }
    }
}