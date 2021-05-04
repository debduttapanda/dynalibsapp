package com.coderusk.dynalibs.customViews

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.coderusk.dynalibs.R
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class VideoPlayer : RelativeLayout, Player.EventListener {
    private var videoPlayer: SimpleExoPlayer? = null
    private var player_initialized: Boolean = false
    var _context: Context
    var pv_video: PlayerView? = null

    constructor(context: Context) : super(context) {
        this._context = context
        initializeViews(context)
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        this._context = context
        initializeViews(context)
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        this._context = context
        initializeViews(context)
        initialize()
    }

    private fun initialize() {
        setupViews()
    }

    private fun initializeVideoPlayer() {
        player_initialized = true
        videoPlayer = SimpleExoPlayer.Builder(_context).build()
        videoPlayer?.addListener(this)
        pv_video?.player = videoPlayer
    }

    private fun setupViews() {
        findViews()
        setupViewActions()
        initializeVideoPlayer()
    }

    private fun findViews() {
        pv_video = findViewById(R.id.pv_video)
    }

    private fun setupViewActions() {}
    private fun initializeViews(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.asset_player_view_layout, this)
    }

    fun set(url: String) {
        if(player_initialized)
        {
            buildMediaSource(url)?.let {
                videoPlayer?.prepare(it, false, true)
            }
        }
    }

    fun play()
    {
        videoPlayer?.playWhenReady = true
    }

    fun stop()
    {
        if(player_initialized)
        {
            videoPlayer?.stop()
        }
    }

    fun release()
    {
        if(player_initialized)
        {
            videoPlayer?.release()
        }
    }

    fun pause()
    {
        if(player_initialized)
        {
            videoPlayer?.pause()
        }
    }

    private fun buildMediaSource(url: String): MediaSource? {
        val dataSourceFactory = DefaultDataSourceFactory(context, "sample")
        return ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(url))
    }
}