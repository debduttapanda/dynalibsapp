package com.coderusk.dynalibs.rendering.parser.implementation

import android.webkit.WebView
import android.webkit.WebViewClient
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.WebViewRenderer
import com.coderusk.dynalibs.sGetString
import org.json.JSONObject

object WebViewRendererImpl : WebViewRenderer {
    override fun render(view: WebView, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.viewAttributesRenderer.render(view,attributes,renderer)
        view.webViewClient = WebViewClient()
        view.clearCache(true)
        view.clearHistory()
        view.settings.setJavaScriptEnabled(true)
        view.settings.javaScriptCanOpenWindowsAutomatically = true
        attributes.sGetString(F.url){ url->
            view.loadUrl(url)
        }
        attributes.sGetString(F.data){
            view.loadData(it, "text/html", "UTF-8");
        }
    }
}