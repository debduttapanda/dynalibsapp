package com.coderusk.dynalibs.rendering.parser.implementation

import android.text.InputType
import com.coderusk.dynalibs.rendering.parser.interfaces.InputTypeParser

object InputTypeParserImpl : InputTypeParser {
    override fun parse(input: String): Int {
        return if(!input.contains("|"))
        {
            singleInputType(input)
        }
        else
        {
            var parts = input.split("|")
            var num = 0
            for(i in parts.indices){
                var part = parts[i]
                var n = singleInputType(part)
                num = num or n
            }
            num
        }
    }

    private fun singleInputType(it: String): Int {
        return when(it){
            "TYPE_TEXT_VARIATION_EMAIL_ADDRESS" -> InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            "TYPE_CLASS_DATETIME" -> InputType.TYPE_CLASS_DATETIME
            "TYPE_CLASS_NUMBER" -> InputType.TYPE_CLASS_NUMBER
            "TYPE_CLASS_PHONE" -> InputType.TYPE_CLASS_PHONE
            "TYPE_CLASS_TEXT" -> InputType.TYPE_CLASS_TEXT
            "TYPE_NUMBER_FLAG_DECIMAL" -> InputType.TYPE_NUMBER_FLAG_DECIMAL
            "TYPE_NUMBER_FLAG_SIGNED" -> InputType.TYPE_NUMBER_FLAG_SIGNED
            "TYPE_NUMBER_VARIATION_NORMAL" -> InputType.TYPE_NUMBER_VARIATION_NORMAL
            "TYPE_TEXT_FLAG_AUTO_COMPLETE" -> InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE
            "TYPE_TEXT_FLAG_AUTO_CORRECT" -> InputType.TYPE_TEXT_FLAG_AUTO_CORRECT
            "TYPE_TEXT_FLAG_CAP_CHARACTERS" -> InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
            "TYPE_TEXT_FLAG_CAP_SENTENCES" -> InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
            "TYPE_TEXT_FLAG_CAP_WORDS" -> InputType.TYPE_TEXT_FLAG_CAP_WORDS
            "TYPE_TEXT_FLAG_IME_MULTI_LINE" -> InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE
            "TYPE_TEXT_FLAG_MULTI_LINE" -> InputType.TYPE_TEXT_FLAG_MULTI_LINE
            "TYPE_TEXT_FLAG_NO_SUGGESTIONS" -> InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
            "TYPE_TEXT_VARIATION_FILTER" -> InputType.TYPE_TEXT_VARIATION_FILTER
            "TYPE_TEXT_VARIATION_NORMAL" -> InputType.TYPE_TEXT_VARIATION_NORMAL
            "TYPE_TEXT_VARIATION_PASSWORD" -> InputType.TYPE_TEXT_VARIATION_PASSWORD
            "TYPE_TEXT_VARIATION_PHONETIC" -> InputType.TYPE_TEXT_VARIATION_PHONETIC
            "TYPE_TEXT_VARIATION_URI" -> InputType.TYPE_TEXT_VARIATION_URI
            else-> InputType.TYPE_CLASS_TEXT
        }
    }
}