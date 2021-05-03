package com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.implementations

import android.widget.FrameLayout
import com.coderusk.dynalibs.SPR
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.interfaces.FrameLayoutLayoutParamsRenderer
import org.json.JSONObject

class FrameLayoutLayoutParamsRendererImpl: ViewGroupLayoutParamsRendererImpl(), FrameLayoutLayoutParamsRenderer {
    override fun render(renderer: Renderer, layoutParams: FrameLayout.LayoutParams, childData: JSONObject) {
        super.render(renderer, layoutParams, childData)
        try {
            if(childData.has(F.attributes))
            {
                val attributes = childData.getJSONObject(F.attributes)
                attributes.SPR(F.layout_gravity){
                    layoutParams.gravity = renderer.factory.gravityParser.parse(it as String)
                }
            }
        } catch (e: Exception) {
        }
    }
}