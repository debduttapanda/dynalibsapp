package com.coderusk.dynalibs.rendering

import android.view.ViewGroup
import com.coderusk.dynalibs.DimensionParser
import com.coderusk.dynalibs.rendering.paramrendering.xpr.SPR
import org.json.JSONObject

open class ViewGroupLayoutParamsRenderer {
    fun render(renderer: Renderer, layoutParams: ViewGroup.LayoutParams, childData: JSONObject)
    {
        if(childData.has(F.attributes))
        {
            try {
                val attributes = childData.getJSONObject(F.attributes)
                val paramRenderings = arrayListOf(
                    SPR.create(F.layout_width){
                        val value = DimensionParser.parse(it as String,renderer)
                        layoutParams.width = value
                    },
                    SPR.create(F.layout_height){
                        val value = DimensionParser.parse(it as String,renderer)
                        layoutParams.height = value
                    }
                )
                paramRenderings.forEach{
                    it.execute(attributes)
                }
                if(layoutParams is ViewGroup.MarginLayoutParams)
                {
                    var marginParams = arrayListOf(
                        SPR.create(F.layout_marginStart){
                            layoutParams.marginStart = DimensionParser.parse(it as String,renderer)
                        },
                        SPR.create(F.layout_marginEnd){
                            layoutParams.marginEnd = DimensionParser.parse(it as String,renderer)
                        },
                        SPR.create(F.layout_marginLeft){
                            layoutParams.leftMargin = DimensionParser.parse(it as String,renderer)
                        },
                        SPR.create(F.layout_marginRight){
                            layoutParams.rightMargin = DimensionParser.parse(it as String,renderer)
                        },
                        SPR.create(F.layout_marginHorizontal){
                            val margin = DimensionParser.parse(it as String,renderer)
                            layoutParams.leftMargin = margin
                            layoutParams.rightMargin = margin
                        },
                        SPR.create(F.layout_marginTop){
                            layoutParams.topMargin = DimensionParser.parse(it as String,renderer)
                        },
                        SPR.create(F.layout_marginBottom){
                            layoutParams.bottomMargin = DimensionParser.parse(it as String,renderer)
                        },
                        SPR.create(F.layout_marginVertical){
                            val margin = DimensionParser.parse(it as String,renderer)
                            layoutParams.bottomMargin = margin
                            layoutParams.topMargin = margin
                        },
                        SPR.create(F.layout_margin){
                            val margin = DimensionParser.parse(it as String,renderer)
                            layoutParams.setMargins(margin,margin,margin,margin)
                        }
                    )
                    marginParams.forEach{
                        it.execute(attributes)
                    }
                }
            } catch (e: Exception) {
            }
        }
    }
}