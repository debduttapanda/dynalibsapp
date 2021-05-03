package com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.implementations

import android.widget.RelativeLayout
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.paramrendering.xpr.BPR
import com.coderusk.dynalibs.rendering.paramrendering.ParamRendering
import com.coderusk.dynalibs.rendering.paramrendering.xpr.SPR
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.interfaces.RelativeLayoutLayoutParamsRenderer
import org.json.JSONObject

class RelativeLayoutLayoutParamsRendererImpl: ViewGroupLayoutParamsRendererImpl(), RelativeLayoutLayoutParamsRenderer {
    override fun render(renderer: Renderer, layoutParams: RelativeLayout.LayoutParams, childData: JSONObject) {
        super.render(renderer, layoutParams, childData)
        try {
            if(childData.has(F.attributes))
            {
                try {
                    var attributes = childData.getJSONObject(F.attributes)
                    var paramRenderings = arrayListOf(
                        SPR.create(F.layout_above){
                            layoutParams.addRule(RelativeLayout.ABOVE,renderer.getId(it as String))
                        },
                        SPR.create(F.layout_alignBaseline){
                            layoutParams.addRule(RelativeLayout.ALIGN_BASELINE,renderer.getId(it as String))
                        },
                        SPR.create(F.layout_alignBottom){
                            layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM,renderer.getId(it as String))
                        },
                        SPR.create(F.layout_alignEnd){
                            layoutParams.addRule(RelativeLayout.ALIGN_END,renderer.getId(it as String))
                        },
                        SPR.create(F.layout_alignLeft){
                            layoutParams.addRule(RelativeLayout.ALIGN_LEFT,renderer.getId(it as String))
                        },
                        SPR.create(F.layout_alignRight){
                            layoutParams.addRule(RelativeLayout.ALIGN_RIGHT,renderer.getId(it as String))
                        },
                        SPR.create(F.layout_alignStart){
                            layoutParams.addRule(RelativeLayout.ALIGN_START,renderer.getId(it as String))
                        },
                        SPR.create(F.layout_alignTop){
                            layoutParams.addRule(RelativeLayout.ALIGN_TOP,renderer.getId(it as String))
                        },
                        SPR.create(F.layout_below){
                            layoutParams.addRule(RelativeLayout.BELOW,renderer.getId(it as String))
                        },
                        SPR.create(F.layout_toEndOf){
                            layoutParams.addRule(RelativeLayout.END_OF,renderer.getId(it as String))
                        },
                        SPR.create(F.layout_toLeftOf){
                            layoutParams.addRule(RelativeLayout.LEFT_OF,renderer.getId(it as String))
                        },
                        SPR.create(F.layout_toRightOf){
                            layoutParams.addRule(RelativeLayout.RIGHT_OF,renderer.getId(it as String))
                        },
                        SPR.create(F.layout_toStartOf){
                            layoutParams.addRule(RelativeLayout.START_OF,renderer.getId(it as String))
                        },
                        ////////////////////////////
                        ParamRendering(F.layout_alignParentBottom, ParamRendering.Type.BOOLEAN){
                            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE)
                        },
                        BPR.create(F.layout_alignParentEnd){
                            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END,RelativeLayout.TRUE)
                        },
                        BPR.create(F.layout_alignParentLeft){
                            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE)
                        },
                        BPR.create(F.layout_alignParentRight){
                            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE)
                        },
                        BPR.create(F.layout_alignParentStart){
                            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_START,RelativeLayout.TRUE)
                        },
                        BPR.create(F.layout_alignParentTop){
                            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE)
                        },
                        BPR.create(F.layout_alignWithParentIfMissing){
                            layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL,RelativeLayout.TRUE)
                        },
                        BPR.create(F.layout_centerHorizontal){
                            layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL,RelativeLayout.TRUE)
                        },
                        BPR.create(F.layout_centerInParent){
                            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE)
                        },
                        BPR.create(F.layout_centerVertical){
                            layoutParams.addRule(RelativeLayout.CENTER_VERTICAL,RelativeLayout.TRUE)
                        }
                    )
                    paramRenderings.forEach{
                        it.execute(attributes)
                    }
                } catch (e: Exception) {
                }
            }
        } catch (e: Exception) {
        }
    }
}