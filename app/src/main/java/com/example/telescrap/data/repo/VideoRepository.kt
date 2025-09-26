package com.example.telescrap.data.repo

import com.example.telescrap.model.VideoMetaResponse
import com.example.telescrap.service.RetrofitClient

class VideoRepository {
    suspend fun getVideoMeta(url: String, cookie: String): VideoMetaResponse {
        return RetrofitClient.api.getVideoMeta(url, cookie)
    }
}