package com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.implementations

import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.interfaces.LayoutParamRenderer
import org.json.JSONObject

object LayoutParamRendererImpl: LayoutParamRenderer {
    override fun render(renderer: Renderer, layoutParams: ViewGroup.LayoutParams, childData: JSONObject)
    {
        if(layoutParams is ConstraintLayout.LayoutParams)
        {
            ConstraintLayoutLayoutParamsRendererImpl().render(renderer,layoutParams,childData)
            return
        }
        if(layoutParams is FrameLayout.LayoutParams)
        {
            FrameLayoutLayoutParamsRendererImpl().render(renderer,layoutParams,childData)
            return
        }
        if(layoutParams is RelativeLayout.LayoutParams)
        {
            RelativeLayoutLayoutParamsRendererImpl().render(renderer,layoutParams,childData)
            return
        }
        if(layoutParams is RadioGroup.LayoutParams)
        {
            LinearLayoutLayoutParamsRendererImpl().render(renderer,layoutParams,childData)
            return
        }
        if(layoutParams is LinearLayout.LayoutParams)
        {
            LinearLayoutLayoutParamsRendererImpl().render(renderer,layoutParams,childData)
            return
        }
        ViewGroupLayoutParamsRendererImpl().render(renderer,layoutParams,childData)
    }
}