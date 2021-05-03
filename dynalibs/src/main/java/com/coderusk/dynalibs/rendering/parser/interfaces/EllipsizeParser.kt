package com.coderusk.dynalibs.rendering.parser.interfaces

import android.text.TextUtils

interface EllipsizeParser {
    fun parse(input: String): TextUtils.TruncateAt
}