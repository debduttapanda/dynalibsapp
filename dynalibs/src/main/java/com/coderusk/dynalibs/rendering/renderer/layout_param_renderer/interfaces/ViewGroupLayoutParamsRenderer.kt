package com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.interfaces

import android.view.ViewGroup
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface ViewGroupLayoutParamsRenderer {
    fun render(renderer: Renderer, layoutParams: ViewGroup.LayoutParams, childData: JSONObject)
}