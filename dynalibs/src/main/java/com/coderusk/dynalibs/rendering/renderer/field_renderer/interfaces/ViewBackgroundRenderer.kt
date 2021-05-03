package com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces

import android.view.View
import com.coderusk.dynalibs.rendering.renderer.Renderer

interface ViewBackgroundRenderer {
    fun render(view: View, value: String, renderer: Renderer)
}