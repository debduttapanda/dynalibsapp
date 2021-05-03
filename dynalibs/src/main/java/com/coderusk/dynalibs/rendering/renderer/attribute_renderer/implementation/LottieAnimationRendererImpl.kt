package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.animation.ValueAnimator
import com.airbnb.lottie.LottieAnimationView
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.LottieAnimationRenderer
import com.coderusk.dynalibs.sGetString
import org.json.JSONObject

object LottieAnimationRendererImpl : LottieAnimationRenderer {
    override fun render(view: LottieAnimationView, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.viewAttributesRenderer.render(view,attributes,renderer)
        view.addLottieOnCompositionLoadedListener{
            view.removeAllLottieOnCompositionLoadedListener()
            view.playAnimation()
            view.repeatCount = ValueAnimator.INFINITE
        }
        attributes.sGetString(F.lottie_url){
            view.setAnimationFromUrl(it)
        }
    }
}