package com.coderusk.dynalibs.rendering.parser.implementation

import android.text.Layout
import com.coderusk.dynalibs.rendering.parser.interfaces.JustificationModeParser

object JustificationModeParserImpl : JustificationModeParser {
    override fun parse(input: String): Int {
        return when(input){
            "none" -> Layout.JUSTIFICATION_MODE_NONE
            "inter_word" -> Layout.JUSTIFICATION_MODE_INTER_WORD
            else-> Layout.JUSTIFICATION_MODE_NONE
        }
    }
}