package com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.interfaces

import androidx.constraintlayout.widget.ConstraintLayout
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface ConstraintLayoutLayoutParamsRenderer {
    fun render(renderer: Renderer, layoutParams: ConstraintLayout.LayoutParams, childData: JSONObject)
}