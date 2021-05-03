package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import android.webkit.WebView
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface WebViewRenderer {
    fun render(view: WebView, attributes: JSONObject, renderer: Renderer)
}