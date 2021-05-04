package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.widget.RadioButton
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.RadioButtonAttributesRenderer
import org.json.JSONObject

object RadioButtonAttributesRendererImpl : RadioButtonAttributesRenderer {
    override fun render(view: RadioButton, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.compoundButtonAttributesRenderer.render(view,attributes,renderer)
    }
}