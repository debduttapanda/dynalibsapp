package com.coderusk.dynalibs.rendering.parser.implementation

import android.view.View
import com.coderusk.dynalibs.rendering.parser.interfaces.TextAlignmentParser

object TextAlignmentParserImpl: TextAlignmentParser {
    override fun parse(input: String): Int{
        return when(input.toUpperCase()){
            "INHERIT"->View.TEXT_ALIGNMENT_INHERIT
            "GRAVITY"->View.TEXT_ALIGNMENT_GRAVITY
            "CENTER"->View.TEXT_ALIGNMENT_CENTER
            "TEXT_START"->View.TEXT_ALIGNMENT_TEXT_START
            "TEXT_END"->View.TEXT_ALIGNMENT_TEXT_END
            "VIEW_START"->View.TEXT_ALIGNMENT_VIEW_START
            "VIEW_END"->View.TEXT_ALIGNMENT_VIEW_END
            else->View.TEXT_ALIGNMENT_INHERIT
        }
    }
}