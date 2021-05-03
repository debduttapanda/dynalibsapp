package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import androidx.cardview.widget.CardView
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface CardViewAttributesRenderer {
    fun render(view: CardView, attributes: JSONObject, renderer: Renderer)
}