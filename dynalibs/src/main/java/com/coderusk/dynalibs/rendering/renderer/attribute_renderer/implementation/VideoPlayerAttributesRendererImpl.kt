package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import com.coderusk.dynalibs.customViews.VideoPlayer
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.VideoPlayerAttributesRenderer
import com.coderusk.dynalibs.sGetString
import org.json.JSONObject

object VideoPlayerAttributesRendererImpl : VideoPlayerAttributesRenderer {
    override fun render(view: VideoPlayer, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.viewAttributesRenderer.render(view,attributes,renderer)
        attributes.sGetString(F.url){
            view.set(it)
        }
    }
}