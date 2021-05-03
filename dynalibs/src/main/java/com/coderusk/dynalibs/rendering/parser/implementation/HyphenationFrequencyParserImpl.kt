package com.coderusk.dynalibs.rendering.parser.implementation

import android.text.Layout
import com.coderusk.dynalibs.rendering.parser.interfaces.HyphenationFrequencyParser

object HyphenationFrequencyParserImpl : HyphenationFrequencyParser {
    override fun parse(input: String): Int {
        return when(input.toLowerCase()){
            "none" -> Layout.HYPHENATION_FREQUENCY_NONE
            "normal" -> Layout.HYPHENATION_FREQUENCY_NORMAL
            "full" -> Layout.HYPHENATION_FREQUENCY_FULL
            else-> Layout.HYPHENATION_FREQUENCY_NORMAL
        }
    }
}