package com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces

import android.widget.TextView
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface TextRenderer {
    fun render(view: TextView, attributes: JSONObject,renderer: Renderer)
}