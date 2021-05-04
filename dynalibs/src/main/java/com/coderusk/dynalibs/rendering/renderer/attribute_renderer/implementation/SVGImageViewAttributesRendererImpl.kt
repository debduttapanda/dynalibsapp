package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.widget.ImageView
import com.coderusk.dynalibs.SPR
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.SVGImageViewAttributesRenderer
import com.coderusk.dynalibs.svg.SVG
import com.coderusk.dynalibs.svg.SVGImageView
import org.json.JSONObject

object SVGImageViewAttributesRendererImpl : SVGImageViewAttributesRenderer {
    override fun render(view: SVGImageView, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.imageViewRenderer.render(view as ImageView,attributes,renderer)
        attributes.SPR(F.svgRaw){
            try {
                var svg = SVG.getFromString(it as String)
                view.setSVG(svg)
            } catch (e: Exception) {
            }
        }
    }
}