package com.coderusk.dynalibs.rendering.renderer.field_renderer.implementations

import android.view.View
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces.ViewForegroundRenderer

object ViewForegroundRendererImpl: ViewForegroundRenderer {
    override fun render(view: View, value: String, renderer: Renderer)
    {
        if(value.startsWith("drawable/"))
        {
            var did = value.replace("drawable/","")
            var drawable = renderer.getDrawable(did)
            if(drawable!=null)
            {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    view.foreground = drawable
                }
            }
        }
        else
        {
            view.setBackgroundColor(renderer.factory.colorParser.parse(value,renderer))
        }
    }
}