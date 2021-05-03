package com.coderusk.dynalibs.rendering.parser.implementation

import android.view.View
import com.coderusk.dynalibs.rendering.parser.interfaces.VisibilityParser

object VisibilityParserImpl: VisibilityParser {
    override fun parse(input: String): Int{
        return when(input){
            "visible"-> View.VISIBLE
            "invisible"-> View.INVISIBLE
            "gone"-> View.GONE
            else-> View.VISIBLE
        }
    }
}