package com.coderusk.dynalibs.rendering.parser.implementation

import android.widget.TextView
import com.coderusk.dynalibs.rendering.parser.interfaces.AutoSizeTextTypeWithDefaultsParser

object AutoSizeTextTypeWithDefaultsParserImpl: AutoSizeTextTypeWithDefaultsParser {
    override fun parse(input: String): Int {
        return when (input.toLowerCase()) {
            "uniform" -> {
                TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM
            }
            else -> {
                TextView.AUTO_SIZE_TEXT_TYPE_NONE
            }
        }
    }
}