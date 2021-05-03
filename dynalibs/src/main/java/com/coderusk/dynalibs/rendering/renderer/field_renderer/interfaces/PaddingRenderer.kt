package com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces

import android.view.View
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface PaddingRenderer {
    fun render(view: View, attributes: JSONObject, renderer: Renderer)
}