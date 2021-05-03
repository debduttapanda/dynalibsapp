package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import com.coderusk.dynalibs.*
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.NavigationViewAttributesRenderer
import com.google.android.material.navigation.NavigationView
import org.json.JSONObject

object NavigationViewAttributesRendererImpl: NavigationViewAttributesRenderer {
    override fun render(view: NavigationView, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.frameLayoutAttributesRenderer.render(view,attributes,renderer)
        attributes.sGetString(F.foregroundGravity) {
            var gravity = renderer.factory.gravityParser.parse(it)
            view.foregroundGravity = gravity
        }
    }
}