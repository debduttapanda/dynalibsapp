package com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.implementations

import android.view.ViewGroup
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.paramrendering.xpr.SPR
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.interfaces.ViewGroupLayoutParamsRenderer
import org.json.JSONObject

open class ViewGroupLayoutParamsRendererImpl: ViewGroupLayoutParamsRenderer {
    override fun render(renderer: Renderer, layoutParams: ViewGroup.LayoutParams, childData: JSONObject)
    {
        if(childData.has(F.attributes))
        {
            try {
                val attributes = childData.getJSONObject(F.attributes)
                val paramRenderings = arrayListOf(
                    SPR.create(F.layout_width){
                        val value = renderer.factory.dimensionParser.parse(it as String,renderer)
                        layoutParams.width = value
                    },
                    SPR.create(F.layout_height){
                        val value = renderer.factory.dimensionParser.parse(it as String,renderer)
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
                            layoutParams.marginStart = renderer.factory.dimensionParser.parse(it as String,renderer)
                        },
                        SPR.create(F.layout_marginEnd){
                            layoutParams.marginEnd = renderer.factory.dimensionParser.parse(it as String,renderer)
                        },
                        SPR.create(F.layout_marginLeft){
                            layoutParams.leftMargin = renderer.factory.dimensionParser.parse(it as String,renderer)
                        },
                        SPR.create(F.layout_marginRight){
                            layoutParams.rightMargin = renderer.factory.dimensionParser.parse(it as String,renderer)
                        },
                        SPR.create(F.layout_marginHorizontal){
                            val margin = renderer.factory.dimensionParser.parse(it as String,renderer)
                            layoutParams.leftMargin = margin
                            layoutParams.rightMargin = margin
                        },
                        SPR.create(F.layout_marginTop){
                            layoutParams.topMargin = renderer.factory.dimensionParser.parse(it as String,renderer)
                        },
                        SPR.create(F.layout_marginBottom){
                            layoutParams.bottomMargin = renderer.factory.dimensionParser.parse(it as String,renderer)
                        },
                        SPR.create(F.layout_marginVertical){
                            val margin = renderer.factory.dimensionParser.parse(it as String,renderer)
                            layoutParams.bottomMargin = margin
                            layoutParams.topMargin = margin
                        },
                        SPR.create(F.layout_margin){
                            val margin = renderer.factory.dimensionParser.parse(it as String,renderer)
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