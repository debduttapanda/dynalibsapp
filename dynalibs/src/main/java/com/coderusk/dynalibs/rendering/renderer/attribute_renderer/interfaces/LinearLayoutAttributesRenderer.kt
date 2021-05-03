package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import android.widget.LinearLayout
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface LinearLayoutAttributesRenderer {
    fun render(view: LinearLayout, attributes: JSONObject, renderer: Renderer)
}