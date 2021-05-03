package com.coderusk.dynalibs.rendering.parser.interfaces

import android.graphics.PorterDuff

interface TintModeParser {
    fun parse(input: String): PorterDuff.Mode
}