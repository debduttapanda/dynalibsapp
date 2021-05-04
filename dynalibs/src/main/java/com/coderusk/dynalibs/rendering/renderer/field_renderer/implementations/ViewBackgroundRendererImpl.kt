package com.coderusk.dynalibs.rendering.renderer.field_renderer.implementations

import android.R
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import android.util.StateSet
import android.view.View
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces.ViewBackgroundRenderer


object ViewBackgroundRendererImpl: ViewBackgroundRenderer {
    override fun render(view: View, value: String, renderer: Renderer)
    {
        if(value.startsWith("drawable/"))
        {
            var did = value.replace("drawable/", "")
            var drawable = renderer.getDrawable(did)
            if(drawable!=null)
            {
                view.background = drawable
            }
        }
        else
        {
            view.setBackgroundColor(renderer.factory.colorParser.parse(value, renderer))
        }
    }

    private fun getDrawableTemp(): Drawable? {
        val stateListDrawable = StateListDrawable()
        stateListDrawable.addState(intArrayOf(R.attr.state_checked), ColorDrawable(Color.BLUE))
        stateListDrawable.addState(intArrayOf(R.attr.state_pressed), ColorDrawable(Color.GREEN))
        stateListDrawable.addState(StateSet.WILD_CARD, ColorDrawable(Color.RED))
        return stateListDrawable
    }
}