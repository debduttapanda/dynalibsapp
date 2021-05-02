package com.coderusk.dynalibs.rendering

import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.coderusk.dynalibs.*
import org.json.JSONObject

class ConstraintLayoutLayoutParamsRenderer: ViewGroupLayoutParamsRenderer() {
    fun render(renderer: Renderer, layoutParams: ConstraintLayout.LayoutParams, childData: JSONObject) {
        super.render(renderer, layoutParams, childData)
        try {
            if(childData.has(F.attributes))
            {
                val attributes = childData.getJSONObject(F.attributes)

                attributes.BPR(F.constrainedHeight){
                    layoutParams.constrainedHeight = it as Boolean
                }
                attributes.BPR(F.constrainedWidth){
                    layoutParams.constrainedWidth = it as Boolean
                }
                attributes.FPR(F.circleAngle){
                    layoutParams.circleAngle = it as Float
                }
                attributes.FPR(F.guidePercent){
                    layoutParams.guidePercent = it as Float
                }
                attributes.FPR(F.horizontalBias){
                    layoutParams.horizontalBias = it as Float
                }
                attributes.FPR(F.horizontalWeight){
                    layoutParams.horizontalWeight = it as Float
                }
                attributes.FPR(F.matchConstraintPercentHeight){
                    layoutParams.matchConstraintPercentHeight = it as Float
                }
                attributes.FPR(F.matchConstraintPercentWidth){
                    layoutParams.matchConstraintPercentWidth = it as Float
                }
                attributes.FPR(F.verticalBias){
                    layoutParams.verticalBias = it as Float
                }
                attributes.FPR(F.verticalWeight){
                    layoutParams.verticalWeight = it as Float
                }
                attributes.SPR(F.baselineToBaseline){
                    layoutParams.baselineToBaseline = renderer.getId(it as String)
                }
                attributes.SPR(F.bottomToBottom){
                    layoutParams.bottomToBottom = renderer.getId(it as String)
                }
                attributes.SPR(F.bottomToTop){
                    layoutParams.bottomToTop = renderer.getId(it as String)
                }
                attributes.SPR(F.circleConstraint){
                    layoutParams.circleConstraint = renderer.getId(it as String)
                }
                attributes.IPR(F.circleRadius){
                    layoutParams.circleRadius = it as Int
                }
                attributes.SPR(F.endToEnd){
                    layoutParams.endToEnd = renderer.getId(it as String)
                }
                attributes.SPR(F.leftToLeft){
                    layoutParams.leftToLeft = renderer.getId(it as String)
                }
                attributes.SPR(F.leftToRight){
                    layoutParams.leftToRight = renderer.getId(it as String)
                }



                attributes.SPR(F.goneBottomMargin){
                    layoutParams.goneBottomMargin = DimensionParser.parse(it as String,renderer)
                }
                attributes.SPR(F.goneEndMargin){
                    layoutParams.goneEndMargin = DimensionParser.parse(it as String,renderer)
                }
                attributes.SPR(F.goneLeftMargin){
                    layoutParams.goneLeftMargin = DimensionParser.parse(it as String,renderer)
                }
                attributes.SPR(F.goneRightMargin){
                    layoutParams.goneRightMargin = DimensionParser.parse(it as String,renderer)
                }
                attributes.SPR(F.goneStartMargin){
                    layoutParams.goneStartMargin = DimensionParser.parse(it as String,renderer)
                }
                attributes.SPR(F.goneTopMargin){
                    layoutParams.goneTopMargin = DimensionParser.parse(it as String,renderer)
                }
                attributes.SPR(F.guideBegin){
                    layoutParams.guideBegin = DimensionParser.parse(it as String,renderer)
                }
                attributes.SPR(F.guideEnd){
                    layoutParams.guideEnd = DimensionParser.parse(it as String,renderer)
                }
                attributes.SPR(F.matchConstraintMaxHeight){
                    layoutParams.matchConstraintMaxHeight = DimensionParser.parse(it as String,renderer)
                }
                attributes.SPR(F.matchConstraintMaxWidth){
                    layoutParams.matchConstraintMaxWidth = DimensionParser.parse(it as String,renderer)
                }
                attributes.SPR(F.matchConstraintMinHeight){
                    layoutParams.matchConstraintMinHeight = DimensionParser.parse(it as String,renderer)
                }
                attributes.SPR(F.matchConstraintMinWidth){
                    layoutParams.matchConstraintMinWidth = DimensionParser.parse(it as String,renderer)
                }
                attributes.IPR(F.orientation){
                    layoutParams.orientation = it as Int
                }
                attributes.SPR(F.rightToLeft){
                    layoutParams.rightToLeft = renderer.getId(it as String)
                }
                attributes.SPR(F.rightToRight){
                    layoutParams.rightToRight = renderer.getId(it as String)
                }
                attributes.SPR(F.startToEnd){
                    layoutParams.startToEnd = renderer.getId(it as String)
                }
                attributes.SPR(F.startToStart){
                    layoutParams.startToStart = renderer.getId(it as String)
                }
                attributes.SPR(F.topToBottom){
                    layoutParams.topToBottom = renderer.getId(it as String)
                }
                attributes.SPR(F.verticalChainStyle){
                    layoutParams.verticalChainStyle = when(it)
                    {
                        "spread" -> {
                            ConstraintLayout.LayoutParams.CHAIN_SPREAD
                        }
                        "spread_inside" -> {
                            ConstraintLayout.LayoutParams.CHAIN_SPREAD_INSIDE
                        }
                        "packed" -> {
                            ConstraintLayout.LayoutParams.CHAIN_PACKED
                        }
                        else -> {
                            ConstraintLayout.LayoutParams.CHAIN_SPREAD
                        }
                    }
                }
                attributes.SPR(F.dimensionRatio){
                    layoutParams.dimensionRatio = it as String
                }


                attributes.SPR(F.horizontalChainStyle){
                    layoutParams.horizontalChainStyle = when(it)
                    {
                        "spread" ->ConstraintLayout.LayoutParams.CHAIN_SPREAD
                        "spread_inside" ->ConstraintLayout.LayoutParams.CHAIN_SPREAD_INSIDE
                        "packed" ->ConstraintLayout.LayoutParams.CHAIN_PACKED
                        else -> ConstraintLayout.LayoutParams.CHAIN_SPREAD
                    }
                }
                attributes.SPR(F.matchConstraintDefaultHeight){
                    layoutParams.matchConstraintDefaultHeight = when(it)
                    {
                        "spread" ->ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD
                        "wrap" ->ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_WRAP
                        "percent" ->ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_PERCENT
                        else -> ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD
                    }
                }
                attributes.SPR(F.matchConstraintDefaultWidth){
                    layoutParams.matchConstraintDefaultWidth = when(it)
                    {
                        "spread" ->ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD
                        "wrap" ->ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_WRAP
                        "percent" ->ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_PERCENT
                        else -> ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD
                    }
                }
            }
        } catch (e: Exception) {
        }
    }
}