package com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.interfaces

import android.widget.LinearLayout
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface LinearLayoutLayoutParamsRenderer {
    fun render(renderer: Renderer, layoutParams: LinearLayout.LayoutParams, childData: JSONObject)
}