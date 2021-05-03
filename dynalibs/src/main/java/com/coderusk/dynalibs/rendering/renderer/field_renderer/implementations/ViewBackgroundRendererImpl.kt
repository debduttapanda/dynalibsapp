package com.coderusk.dynalibs.rendering.renderer.field_renderer.implementations

import android.view.View
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces.ViewBackgroundRenderer
import com.coderusk.dynalibs.toColor

object ViewBackgroundRendererImpl: ViewBackgroundRenderer {
    override fun render(view: View, value: String, renderer: Renderer)
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