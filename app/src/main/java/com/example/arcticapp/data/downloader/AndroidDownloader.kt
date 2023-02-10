package com.example.arcticapp.data.downloader

import android.app.DownloadManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.net.toUri

class AndroidDownloader(private val context: Context, private var titleFile: String): Downloader {

    @RequiresApi(Build.VERSION_CODES.M)
    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun downloadFile(url: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("video/mp4")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle(titleFile)
            .setDestinationInExternalFilesDir(context, null, titleFile)
        return downloadManager.enqueue(request)
    }
}