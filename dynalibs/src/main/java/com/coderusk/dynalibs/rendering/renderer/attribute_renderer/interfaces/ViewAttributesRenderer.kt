package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import android.view.View
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface ViewAttributesRenderer {
    fun render(view: View, attributes: JSONObject, renderer: Renderer)
}