package com.coderusk.dynalibs.rendering

import android.widget.FrameLayout
import android.widget.LinearLayout
import com.coderusk.dynalibs.FPR
import com.coderusk.dynalibs.SPR
import org.json.JSONObject

class FrameLayoutLayoutParamsRenderer: ViewGroupLayoutParamsRenderer() {
    fun render(renderer: Renderer, layoutParams: FrameLayout.LayoutParams, childData: JSONObject) {
        super.render(renderer, layoutParams, childData)
        try {
            if(childData.has(F.attributes))
            {
                val attributes = childData.getJSONObject(F.attributes)
                attributes.SPR(F.layout_gravity){
                    layoutParams.gravity = GravityRenderer.render(it as String)
                }
            }
        } catch (e: Exception) {
        }
    }
}