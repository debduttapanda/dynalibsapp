package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.widget.FrameLayout
import com.coderusk.dynalibs.*
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.FrameLayoutAttributesRenderer
import org.json.JSONObject

object FrameLayoutAttributesRendererImpl: FrameLayoutAttributesRenderer {
    override fun render(view: FrameLayout, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.viewAttributesRenderer.render(view, attributes, renderer)
        attributes.sGetString(F.foregroundGravity) {
            var gravity = renderer.factory.gravityParser.parse(it)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                view.foregroundGravity = gravity
            }
        }
    }
}