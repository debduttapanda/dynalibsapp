package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import com.coderusk.dynalibs.customViews.VideoPlayer
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface VideoPlayerAttributesRenderer {
    fun render(view: VideoPlayer, attributes: JSONObject, renderer: Renderer)
}