package com.coderusk.dynalibs.rendering.parser.implementation

import android.view.View
import com.coderusk.dynalibs.rendering.parser.interfaces.FocusableParser
import com.coderusk.dynalibs.rendering.renderer.Renderer

object FocusableParserImpl: FocusableParser {
    override fun parse(input: String, renderer: Renderer): Int{
        return when(input)
        {
            "true"-> View.FOCUSABLE
            "false"-> View.NOT_FOCUSABLE
            else-> View.FOCUSABLE_AUTO
        }
    }
}