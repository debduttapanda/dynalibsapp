package com.coderusk.dynalibs.rendering.parser

import android.text.method.LinkMovementMethod
import android.text.method.MovementMethod
import android.text.method.ScrollingMovementMethod
import com.coderusk.dynalibs.rendering.parser.interfaces.MovementMethodParser

object MovementMethodParserImpl: MovementMethodParser{
    override fun parse(input: String): MovementMethod? {
        return when(input.toLowerCase())
        {
            "link" -> {
                LinkMovementMethod()
            }
            "scroll" -> {
                ScrollingMovementMethod()
            }
            else->{
                null
            }
        }
    }

}
