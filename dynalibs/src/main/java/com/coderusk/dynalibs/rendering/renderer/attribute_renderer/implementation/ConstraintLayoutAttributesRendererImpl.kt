package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import androidx.constraintlayout.widget.ConstraintLayout
import com.coderusk.dynalibs.*
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.ConstraintLayoutAttributesRenderer
import org.json.JSONObject

object ConstraintLayoutAttributesRendererImpl: ConstraintLayoutAttributesRenderer {
    override fun render(view: ConstraintLayout, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.viewAttributesRenderer.render(view, attributes, renderer)
        attributes.sGetString(F.maxHeight) {
            var num = renderer.factory.dimensionParser.parse(it as String, renderer)
            view.maxHeight = num
        }
        attributes.sGetString(F.maxWidth) {
            var num = renderer.factory.dimensionParser.parse(it as String, renderer)
            view.maxWidth = num
        }
        attributes.sGetString(F.minWidth) {
            var num = renderer.factory.dimensionParser.parse(it as String, renderer)
            view.minWidth = num
        }
        attributes.sGetString(F.minHeight) {
            var num = renderer.factory.dimensionParser.parse(it as String, renderer)
            view.minHeight = num
        }
    }
}