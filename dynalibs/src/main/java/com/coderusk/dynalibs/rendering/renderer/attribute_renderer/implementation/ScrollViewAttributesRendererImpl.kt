package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.widget.ScrollView
import com.coderusk.dynalibs.*
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.ScrollViewAttributesRenderer
import org.json.JSONObject

object ScrollViewAttributesRendererImpl: ScrollViewAttributesRenderer {
    override fun render(view: ScrollView, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.frameLayoutAttributesRenderer.render(view,attributes,renderer)
        attributes.sGetBoolean(F.fillViewPort) {
            view.isFillViewport = it
        }
    }
}