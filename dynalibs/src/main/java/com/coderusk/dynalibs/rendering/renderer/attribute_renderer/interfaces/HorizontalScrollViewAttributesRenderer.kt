package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import android.widget.HorizontalScrollView
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface HorizontalScrollViewAttributesRenderer {
    fun render(view: HorizontalScrollView, attributes: JSONObject, renderer: Renderer)
}
