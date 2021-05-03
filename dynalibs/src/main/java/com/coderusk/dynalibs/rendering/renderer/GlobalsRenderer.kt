package com.coderusk.dynalibs.rendering.renderer

import org.json.JSONObject

interface GlobalsRenderer {
    fun render(attributes: JSONObject, renderer: Renderer)
}