package com.coderusk.dynalibs.rendering.parser.interfaces

import com.coderusk.dynalibs.rendering.renderer.Renderer

interface DimensionParser {
    fun parse(layout_width: String, renderer: Renderer): Int
}