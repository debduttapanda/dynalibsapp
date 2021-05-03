package com.coderusk.dynalibs.rendering.parser.implementation

import com.coderusk.dynalibs.rendering.parser.interfaces.TextStyleParser

object TextStyleParserImpl : TextStyleParser {
    override fun parse(input: String): Int {
        return if(!input.contains("|")) {
            singleTextStyle(input)
        } else {
            var parts = input.split("|")
            var ret = 0
            for(i in 0 until parts.size) {
                var part = parts[i]
                ret = ret or singleTextStyle(part)
            }
            ret
        }
    }

    private fun singleTextStyle(it: String): Int {
        return when(it){
            "bold" -> 1
            "italic" -> 2
            else->0
        }
    }
}