package com.coderusk.dynalibs.rendering.parser.implementation

import android.view.View
import com.coderusk.dynalibs.rendering.parser.interfaces.TextDirectionParser

object TextDirectionParserImpl: TextDirectionParser {
    override fun parse(input: String):Int
    {
        return when(input.toUpperCase()){
            "INHERIT"-> View.TEXT_DIRECTION_INHERIT
            "FIRST_STRONG"->View.TEXT_DIRECTION_FIRST_STRONG
            "ANY_RTL"->View.TEXT_DIRECTION_ANY_RTL
            "LTR"->View.TEXT_DIRECTION_LTR
            "RTL"->View.TEXT_DIRECTION_RTL
            "LOCALE"->View.TEXT_DIRECTION_LOCALE
            "FIRST_STRONG_LTR"-> if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                View.TEXT_DIRECTION_FIRST_STRONG_LTR
            } else {
                View.TEXT_DIRECTION_INHERIT
            }
            "FIRST_STRONG_RTL"-> if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                View.TEXT_DIRECTION_FIRST_STRONG_RTL
            } else {
                View.TEXT_DIRECTION_INHERIT
            }
            else->View.TEXT_DIRECTION_INHERIT
        }
    }
}