package com.coderusk.dynalibs.rendering.renderer.field_renderer.implementations

import android.view.View
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces.ScrollIndicatorsRenderer
import org.json.JSONObject

object ScrollIndicatorsRendererImpl: ScrollIndicatorsRenderer {
    override fun render(view: View, attributes: JSONObject){
        var mask = -100
        var indicator = -100
        try {
            if(attributes.has(F.scrollIndicatorMask))
            {
                var sMask = attributes.getString(F.scrollIndicatorMask)
                mask = composeScrollIndicator(sMask)
            }
        } catch (e: Exception) {
        }
        try {
            if(attributes.has(F.scrollIndicator))
            {
                var sMask = attributes.getString(F.scrollIndicator)
                indicator = composeScrollIndicator(sMask)
            }
        } catch (e: Exception) {
        }
        if(indicator!=-100)
        {
            if(mask!=-100)
            {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    view.setScrollIndicators(indicator,mask)
                }
            }
            else
            {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    view.scrollIndicators = indicator
                }
            }
        }
    }

    private fun composeScrollIndicator(sMask: String): Int {
        if(!sMask.contains("|"))
        {
            return singleScrollIndicator(sMask)
        }
        else
        {
            var parts = sMask.split("|")
            var n = parts.size
            var value = 0
            for(i in 0 until value){
                var part = parts[i]
                var v = singleScrollIndicator(part)
                value = value or v
            }
            return value
        }
    }

    private fun singleScrollIndicator(sMask: String): Int {
        return when(sMask){
            "TOP"->View.SCROLL_INDICATOR_TOP
            "BOTTOM"->View.SCROLL_INDICATOR_BOTTOM
            "LEFT"->View.SCROLL_INDICATOR_LEFT
            "RIGHT"->View.SCROLL_INDICATOR_RIGHT
            "START"->View.SCROLL_INDICATOR_START
            "END"->View.SCROLL_INDICATOR_END
            else->0
        }
    }
}