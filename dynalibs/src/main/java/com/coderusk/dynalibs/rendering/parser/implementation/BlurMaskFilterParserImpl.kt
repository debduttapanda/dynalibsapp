package com.coderusk.dynalibs.rendering.parser.implementation

import android.graphics.BlurMaskFilter
import com.coderusk.dynalibs.rendering.parser.interfaces.BlurMaskFilterParser

object BlurMaskFilterParserImpl : BlurMaskFilterParser {
    override fun parse(input: String): BlurMaskFilter.Blur {
        return when(input.toUpperCase()){
            "NORMAL" -> BlurMaskFilter.Blur.NORMAL
            "SOLID" -> BlurMaskFilter.Blur.SOLID
            "OUTER" -> BlurMaskFilter.Blur.OUTER
            "INNER" -> BlurMaskFilter.Blur.INNER
            else-> BlurMaskFilter.Blur.NORMAL
        }
    }
}