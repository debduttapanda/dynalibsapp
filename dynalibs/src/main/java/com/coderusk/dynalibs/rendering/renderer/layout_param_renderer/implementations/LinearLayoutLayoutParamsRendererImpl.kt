package com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.implementations

import android.widget.LinearLayout
import com.coderusk.dynalibs.FPR
import com.coderusk.dynalibs.SPR
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.interfaces.LinearLayoutLayoutParamsRenderer
import org.json.JSONObject

class LinearLayoutLayoutParamsRendererImpl: ViewGroupLayoutParamsRendererImpl(), LinearLayoutLayoutParamsRenderer {
    override fun render(renderer: Renderer, layoutParams: LinearLayout.LayoutParams, childData: JSONObject) {
        super.render(renderer, layoutParams, childData)
        try {
            if(childData.has(F.attributes))
            {
                val attributes = childData.getJSONObject(F.attributes)
                attributes.SPR(F.layout_gravity){
                    layoutParams.gravity = renderer.factory.gravityParser.parse(it as String)
                }
                attributes.FPR(F.layout_weight){
                    layoutParams.weight = it as Float
                }
            }
        } catch (e: Exception) {
        }
    }
}