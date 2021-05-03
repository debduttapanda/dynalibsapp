package com.coderusk.dynalibs.rendering.renderer.field_renderer.implementations

import android.view.View
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces.ViewForegroundRenderer
import com.coderusk.dynalibs.toColor

object ViewForegroundRendererImpl: ViewForegroundRenderer {
    override fun render(view: View, value: String, renderer: Renderer)
    {
        if(value.startsWith("$"))
        {
            var did = value.replace("$","")
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
            view.setBackgroundColor(value.toColor())
        }
    }
}