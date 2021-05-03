package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import android.widget.ImageView
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface ImageViewRenderer {
    fun render(view: ImageView, attributes: JSONObject, renderer: Renderer)
}