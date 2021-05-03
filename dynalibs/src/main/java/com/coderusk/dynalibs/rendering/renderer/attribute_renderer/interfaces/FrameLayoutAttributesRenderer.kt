package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import android.widget.FrameLayout
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface FrameLayoutAttributesRenderer {
    fun render(view: FrameLayout, attributes: JSONObject, renderer: Renderer)
}