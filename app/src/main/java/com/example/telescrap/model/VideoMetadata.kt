package com.example.telescrap.model

import com.google.gson.annotations.SerializedName

// 1. Root Response
data class VideoMetaResponse(
    val seekThumbnailInfo: SeekThumbnailInfo,
    val roi: ROI,
    val encodeStats: EncodeStats
)

data class SeekThumbnailInfo(
    val frameInterval: Int,
    val thumbnailCount: Int,
    val availableFormats: List<ThumbnailFormat>
)

data class ThumbnailFormat(
    val width: Int,
    val height: Int,
    val bifUrl: String
)

data class ROI(
    val width: Double,
    val height: Double,
    val xoffset: Double,
    val yoffset: Double
)

data class EncodeStats(
    @SerializedName("phone-h264")
    val phoneH264: List<EncodeEntry>,
    @SerializedName("tv-h264")
    val tvH264: List<EncodeEntry>,
    @SerializedName("phone-hevc")
    val phoneHevc: List<EncodeEntry>,
    @SerializedName("tv-hevc")
    val tvHevc: List<EncodeEntry>
)

data class EncodeEntry(
    val video: VideoInfo,
    val audio: List<AudioInfo>,
    val total_avg_br: Double,
    val duration: Double,
    val encode_time: Double,
    val weighted_encode_time: Double,
    val num_encode_pods: Int,
    val encode_vendor: String,
    val VMAF_score: Double,
    val method: String
)

data class VideoInfo(
    val width: Int,
    val height: Int,
    val video_br: Double,
    val video_codec: String
)

data class AudioInfo(
    val language: String,
    val audio_br: Double,
    val audio_codec: String,
    val channel: Int
)
