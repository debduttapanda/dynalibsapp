package com.coderusk.dynalibs.rendering.parser.implementation

import android.view.View
import com.coderusk.dynalibs.rendering.parser.interfaces.ScrollbarStyleParser

object ScrollbarStyleParserImpl: ScrollbarStyleParser {
    override fun parse(input: String): Int{
        return when(input.toUpperCase()){
            "INSIDE_OVERLAY"-> View.SCROLLBARS_INSIDE_OVERLAY
            "INSIDE_INSET"->View.SCROLLBARS_INSIDE_INSET
            "OUTSIDE_OVERLAY"->View.SCROLLBARS_OUTSIDE_OVERLAY
            "OUTSIDE_INSET"->View.SCROLLBARS_OUTSIDE_INSET
            else->View.SCROLLBARS_INSIDE_OVERLAY
        }
    }
}