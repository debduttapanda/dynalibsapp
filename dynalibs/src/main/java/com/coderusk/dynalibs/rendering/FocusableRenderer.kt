package com.coderusk.dynalibs.rendering

import android.view.View

object FocusableRenderer {
    fun render(input: String, renderer: Renderer): Int{
        return when(input)
        {
            "true"-> View.FOCUSABLE
            "false"-> View.NOT_FOCUSABLE
            else-> View.FOCUSABLE_AUTO
        }
    }
}