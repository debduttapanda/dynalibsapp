package com.coderusk.dynalibs.rendering.parser.interfaces

import com.coderusk.dynalibs.rendering.renderer.Renderer

interface ColorParser {
    fun parse(input: String, renderer: Renderer): Int
}