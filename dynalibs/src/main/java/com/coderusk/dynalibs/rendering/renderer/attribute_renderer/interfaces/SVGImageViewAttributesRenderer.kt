package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.svg.SVGImageView
import org.json.JSONObject

interface SVGImageViewAttributesRenderer {
    fun render(view: SVGImageView, attributes: JSONObject, renderer: Renderer)
}