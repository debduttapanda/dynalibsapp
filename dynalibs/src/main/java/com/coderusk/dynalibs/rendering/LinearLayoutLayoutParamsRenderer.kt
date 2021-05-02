package com.coderusk.dynalibs.rendering

import android.widget.LinearLayout
import com.coderusk.dynalibs.FPR
import com.coderusk.dynalibs.SPR
import org.json.JSONObject

class LinearLayoutLayoutParamsRenderer: ViewGroupLayoutParamsRenderer() {
    fun render(renderer: Renderer, layoutParams: LinearLayout.LayoutParams, childData: JSONObject) {
        super.render(renderer, layoutParams, childData)
        try {
            if(childData.has(F.attributes))
            {
                val attributes = childData.getJSONObject(F.attributes)
                attributes.SPR(F.layout_gravity){
                    layoutParams.gravity = GravityRenderer.render(it as String)
                }
                attributes.FPR(F.layout_weight){
                    layoutParams.weight = it as Float
                }
            }
        } catch (e: Exception) {
        }
    }
}