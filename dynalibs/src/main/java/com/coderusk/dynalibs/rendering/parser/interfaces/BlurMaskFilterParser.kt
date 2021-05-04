package com.coderusk.dynalibs.rendering.parser.interfaces

import android.graphics.BlurMaskFilter

interface BlurMaskFilterParser {
    fun parse(input: String): BlurMaskFilter.Blur
}