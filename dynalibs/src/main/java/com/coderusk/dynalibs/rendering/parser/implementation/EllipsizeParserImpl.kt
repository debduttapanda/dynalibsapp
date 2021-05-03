package com.coderusk.dynalibs.rendering.parser.implementation

import android.text.TextUtils
import com.coderusk.dynalibs.rendering.parser.interfaces.EllipsizeParser

object EllipsizeParserImpl : EllipsizeParser {
    override fun parse(input: String): TextUtils.TruncateAt {
        return when(input){
            "marquee" -> TextUtils.TruncateAt.MARQUEE
            "end" -> TextUtils.TruncateAt.END
            "start" -> TextUtils.TruncateAt.START
            "middle" -> TextUtils.TruncateAt.MIDDLE
            else-> TextUtils.TruncateAt.END
        }
    }
}