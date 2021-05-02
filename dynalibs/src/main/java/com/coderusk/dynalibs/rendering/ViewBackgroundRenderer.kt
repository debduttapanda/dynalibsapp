package com.coderusk.dynalibs.rendering

import android.view.View
import com.coderusk.dynalibs.toColor

object ViewBackgroundRenderer {
    fun render(view: View, value: String, renderer: Renderer)
    {
        if(value.startsWith("$"))
        {
            var did = value.replace("$","")
            var drawable = renderer.getDrawable(did)
            if(drawable!=null)
            {
                view.background = drawable
            }
        }
        else
        {
            view.setBackgroundColor(value.toColor())
        }
    }
}