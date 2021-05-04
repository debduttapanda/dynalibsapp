package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.widget.HorizontalScrollView
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.HorizontalScrollViewAttributesRenderer
import com.coderusk.dynalibs.sGetBoolean
import org.json.JSONObject

object HorizontalScrollViewAttributesRendererImpl: HorizontalScrollViewAttributesRenderer {
    override fun render(view: HorizontalScrollView, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.frameLayoutAttributesRenderer.render(view,attributes,renderer)
        attributes.sGetBoolean(F.fillViewPort) {
            view.isFillViewport = it
        }
    }

}
