package com.example.arcticapp.data.downloader

interface Downloader {
    fun downloadFile(url: String): Long
}