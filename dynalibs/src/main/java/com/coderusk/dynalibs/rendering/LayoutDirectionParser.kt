package com.coderusk.dynalibs.rendering

import android.util.LayoutDirection

object LayoutDirectionParser {
    fun parse(input: String): Int{
        return when(input.toLowerCase()){
            "rtl"->LayoutDirection.RTL
            "ltr"->LayoutDirection.LTR
            "locale"->LayoutDirection.LOCALE
            else->LayoutDirection.INHERIT
        }
    }
}