package com.coderusk.dynalibs.rendering

import android.view.FrameMetrics
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import org.json.JSONObject

object LayoutParamRenderer {
    fun render(renderer: Renderer, layoutParams: ViewGroup.LayoutParams, childData: JSONObject)
    {
        if(layoutParams is ConstraintLayout.LayoutParams)
        {
            RelativeLayoutLayoutParamsRenderer().render(renderer,layoutParams,childData)
            return
        }
        if(layoutParams is FrameLayout.LayoutParams)
        {
            FrameLayoutLayoutParamsRenderer().render(renderer,layoutParams,childData)
            return
        }
        if(layoutParams is FrameLayout.LayoutParams)
        {
            FrameLayoutLayoutParamsRenderer().render(renderer,layoutParams,childData)
            return
        }
        if(layoutParams is RelativeLayout.LayoutParams)
        {
            RelativeLayoutLayoutParamsRenderer().render(renderer,layoutParams,childData)
            return
        }
        if(layoutParams is RadioGroup.LayoutParams)
        {
            LinearLayoutLayoutParamsRenderer().render(renderer,layoutParams,childData)
            return
        }
        if(layoutParams is LinearLayout.LayoutParams)
        {
            LinearLayoutLayoutParamsRenderer().render(renderer,layoutParams,childData)
            return
        }
        ViewGroupLayoutParamsRenderer().render(renderer,layoutParams,childData)
    }
}