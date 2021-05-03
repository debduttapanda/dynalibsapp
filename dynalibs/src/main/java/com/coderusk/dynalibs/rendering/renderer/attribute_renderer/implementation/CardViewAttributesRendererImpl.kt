package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import androidx.cardview.widget.CardView
import com.coderusk.dynalibs.*
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.CardViewAttributesRenderer
import org.json.JSONObject

object CardViewAttributesRendererImpl: CardViewAttributesRenderer {
    override fun render(view: CardView, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.frameLayoutAttributesRenderer.render(view, attributes, renderer)
        attributes.sGetString(F.cardBackgroundColor) {
            view.setCardBackgroundColor(it.toColor())
        }
        attributes.sGetString(F.cardElevation) {
            view.cardElevation = renderer.factory.dimensionParser.parse(it,renderer).toFloat()
        }
        attributes.sGetString(F.maxCardElevation) {
            view.maxCardElevation = renderer.factory.dimensionParser.parse(it,renderer).toFloat()
        }
        attributes.sGetString(F.minHeight) {
            view.minimumHeight = renderer.factory.dimensionParser.parse(it,renderer)
        }
        attributes.sGetString(F.minWidth) {
            view.minimumWidth = renderer.factory.dimensionParser.parse(it,renderer)
        }
        attributes.sGetString(F.radius) {
            view.radius = renderer.factory.dimensionParser.parse(it,renderer).toFloat()
        }
        attributes.sGetBoolean(F.useCompatPadding) {
            view.useCompatPadding = it
        }
    }
}