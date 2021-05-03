package com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.interfaces

import android.widget.RelativeLayout
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface RelativeLayoutLayoutParamsRenderer {
    fun render(renderer: Renderer, layoutParams: RelativeLayout.LayoutParams, childData: JSONObject)
}