package com.example.telescrap.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.telescrap.data.repo.VideoRepository
import kotlinx.coroutines.Dispatchers

class VideoViewModel(private val repository: VideoRepository) : ViewModel() {

    fun fetchVideoMeta(url: String, cookie: String) = liveData(Dispatchers.IO) {
        try {
            val response = repository.getVideoMeta(url, cookie)
            Log.d("TAG", "fetchVideoMeta:${response} ")
            emit(response)
        } catch (e: Exception) {
            Log.d("TAG", "fetchVideoMeta:${e.message} ")
            emit(null)
        }
    }
}
