package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.widget.CheckBox
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.CheckBoxAttributesRenderer
import org.json.JSONObject

object CheckBoxAttributesRendererImpl : CheckBoxAttributesRenderer {
    override fun render(view: CheckBox, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.compoundButtonAttributesRenderer.render(view,attributes,renderer)
    }
}