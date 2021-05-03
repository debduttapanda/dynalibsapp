package com.coderusk.dynalibs.rendering.parser.interfaces

import android.graphics.Paint
import org.json.JSONObject

interface PaintParser {
    fun parse(input: JSONObject?): Paint?
}