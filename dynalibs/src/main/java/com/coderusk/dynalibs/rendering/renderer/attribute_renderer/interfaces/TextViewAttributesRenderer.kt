package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import android.widget.TextView
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface TextViewAttributesRenderer {
    fun render(view: TextView, attributes: JSONObject, renderer: Renderer)
}