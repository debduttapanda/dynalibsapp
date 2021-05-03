package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import com.airbnb.lottie.LottieAnimationView
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface LottieAnimationRenderer {
    fun render(view: LottieAnimationView, attributes: JSONObject, renderer: Renderer)
}