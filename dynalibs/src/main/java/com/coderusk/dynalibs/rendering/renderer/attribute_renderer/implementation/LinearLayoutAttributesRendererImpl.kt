package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.widget.LinearLayout
import com.coderusk.dynalibs.BPR
import com.coderusk.dynalibs.FPR
import com.coderusk.dynalibs.IPR
import com.coderusk.dynalibs.SPR
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.LinearLayoutAttributesRenderer
import org.json.JSONObject

object LinearLayoutAttributesRendererImpl: LinearLayoutAttributesRenderer {
    override fun render(view: LinearLayout, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.viewAttributesRenderer.render(view, attributes, renderer)
        attributes.BPR(F.baselineAligned){
            view.isBaselineAligned = it as Boolean
        }
        attributes.IPR(F.baselineAlignedChildIndex){
            view.baselineAlignedChildIndex = it as Int
        }
        attributes.SPR(F.dividerDrawable){
            view.dividerDrawable = renderer.getDrawable(it as String)
        }
        attributes.SPR(F.gravity){
            view.gravity = renderer.factory.gravityParser.parse(it as String)
        }
        attributes.BPR(F.isMeasureWithLargestChildEnabled){
            view.isMeasureWithLargestChildEnabled = it as Boolean
        }
        attributes.SPR(F.orientation){
            view.orientation = renderer.factory.orientationParser.parse(it as String)
        }
        attributes.FPR(F.orientation){
            view.weightSum = it as Float
        }
    }
}