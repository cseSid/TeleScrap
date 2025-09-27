package com.example.telescrap.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.telescrap.R
import com.example.telescrap.data.repo.VideoRepository
import com.example.telescrap.ui.viewModel.VideoViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: VideoViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                return VideoViewModel(VideoRepository()) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url = "videos/hotstarint/hridayapoorvamtrailer/1271450819/v3/1758815062889/video-meta.json"
        val cookie = "_gcl_au=1.1.205310280.1758478215; _fbp=fb.1.1758478217805.280067671238419904; _gid=GA1.2.2018707596.1758910856; _ga=GA1.2.1283848592.1758478216; _uetsid=8ccfb1b09b0511f096bc112fc1d7c760; _uetvid=3aac9260971611f0b93211a48b7ffa6b; _ga_VJTFGHZ5NH=GS2.2.s1758910857\$o2\$g1\$t1758910934\$j60\$l0\$h0; _ga_QV5FD29XJC=GS2.1.s1758913602\$o3\$g1\$t1758913826\$j37\$l0\$h0; _ga_EPJ8DYH89Z=GS2.1.s1758913602\$o3\$g1\$t1758913827\$j36\$l0\$h0; _ga_2PV8LWETCX=GS2.1.s1758913602\$o3\$g1\$t1758913827\$j36\$l0\$h0"

        findViewById<EditText>(R.id.editVideoId).setText(url)

        findViewById<Button>(R.id.btnFetch).setOnClickListener {
            viewModel.fetchVideoMeta(url, cookie).observe(this) { meta ->
                Log.e("VideoMeta", "Failed to fetch metadata ${meta}")
                if (meta != null) {
                    findViewById<TextView>(R.id.txtMetadata).text = "Bif URL : ${meta.seekThumbnailInfo.availableFormats[0].bifUrl}"
                    Log.d("VideoMeta", "Bif URL : ${meta.seekThumbnailInfo.availableFormats[0].bifUrl}} ")
                } else {
                    Log.e("VideoMeta", "Failed to fetch metadata")
                }
            }
        }

    }
    
    }

