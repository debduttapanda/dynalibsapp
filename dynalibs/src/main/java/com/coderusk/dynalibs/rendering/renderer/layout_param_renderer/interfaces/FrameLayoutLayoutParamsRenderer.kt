package com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.interfaces

import android.widget.FrameLayout
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface FrameLayoutLayoutParamsRenderer {
    fun render(renderer: Renderer, layoutParams: FrameLayout.LayoutParams, childData: JSONObject)
}