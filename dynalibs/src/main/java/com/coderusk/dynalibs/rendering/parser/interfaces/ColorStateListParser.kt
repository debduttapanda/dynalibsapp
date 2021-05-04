package com.coderusk.dynalibs.rendering.parser.interfaces

import android.content.res.ColorStateList
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONArray

interface ColorStateListParser {
    fun parse(input: JSONArray, renderer: Renderer): ColorStateList?
}