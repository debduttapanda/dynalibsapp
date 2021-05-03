package com.coderusk.dynalibs.rendering.parser.interfaces

import android.content.res.ColorStateList
import org.json.JSONArray

interface ColorStateListParser {
    fun parse(input: JSONArray): ColorStateList?
}