package com.coderusk.dynalibs.rendering.parser.interfaces

import android.text.method.MovementMethod

interface MovementMethodParser {
    fun parse(input: String): MovementMethod?
}