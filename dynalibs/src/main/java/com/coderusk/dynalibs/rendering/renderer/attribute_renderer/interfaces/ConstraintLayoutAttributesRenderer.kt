package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import androidx.constraintlayout.widget.ConstraintLayout
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface ConstraintLayoutAttributesRenderer {
    fun render(view: ConstraintLayout, attributes: JSONObject, renderer: Renderer)
}