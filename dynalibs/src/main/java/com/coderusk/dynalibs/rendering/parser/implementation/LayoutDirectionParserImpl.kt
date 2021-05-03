package com.coderusk.dynalibs.rendering.parser.implementation

import android.util.LayoutDirection
import com.coderusk.dynalibs.rendering.parser.interfaces.LayoutDirectionParser

object LayoutDirectionParserImpl: LayoutDirectionParser {
    override fun parse(input: String): Int{
        return when(input.toLowerCase()){
            "rtl"->LayoutDirection.RTL
            "ltr"->LayoutDirection.LTR
            "locale"->LayoutDirection.LOCALE
            else->LayoutDirection.INHERIT
        }
    }
}