package com.coderusk.dynalibs.rendering.parser.implementation

import android.widget.LinearLayout
import com.coderusk.dynalibs.rendering.parser.interfaces.OrientationParser

object OrientationParserImpl: OrientationParser {
    override fun parse(input: String):Int
    {
        return when(input){
            "horizontal"->LinearLayout.HORIZONTAL
            "vertical"->LinearLayout.VERTICAL
            else->LinearLayout.HORIZONTAL
        }
    }
}