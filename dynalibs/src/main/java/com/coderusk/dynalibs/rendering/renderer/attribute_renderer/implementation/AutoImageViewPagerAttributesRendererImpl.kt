package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import com.coderusk.dynalibs.customViews.AutoImageViewPager
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.AutoImageViewPagerAttributesRenderer
import com.coderusk.dynalibs.sGetInt
import com.coderusk.dynalibs.sGetJsonArray
import org.json.JSONObject

object AutoImageViewPagerAttributesRendererImpl : AutoImageViewPagerAttributesRenderer {
    override fun render(view: AutoImageViewPager, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.viewAttributesRenderer.render(view,attributes,renderer)
        var list = ArrayList<String>()
        var timeInMs = 3000
        attributes.sGetJsonArray(F.images){
            try {
                var n = it.length()
                for(i in 0 until n){
                    var item = it[i] as String
                    list.add(item)
                }
            } catch (e: Exception) {
            }
        }
        attributes.sGetInt(F.time){
            timeInMs = it
        }
        if(timeInMs<300)
        {
            timeInMs = 3000
        }
        view.setup(list,timeInMs)
    }
}