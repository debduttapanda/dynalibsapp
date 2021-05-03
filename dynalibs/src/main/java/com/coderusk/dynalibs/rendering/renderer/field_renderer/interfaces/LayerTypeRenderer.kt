package com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces

import android.view.View
import com.coderusk.dynalibs.rendering.renderer.Renderer

interface LayerTypeRenderer {
    fun render(view: View, input: String, renderer: Renderer)
}