package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import android.widget.ScrollView
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface ScrollViewAttributesRenderer {
    fun render(view: ScrollView, attributes: JSONObject, renderer: Renderer)
}