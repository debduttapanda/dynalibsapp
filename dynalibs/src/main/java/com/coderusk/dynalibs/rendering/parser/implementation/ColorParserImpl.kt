package com.coderusk.dynalibs.rendering.parser.implementation

import android.content.Context
import android.graphics.Color
import com.coderusk.dynalibs.Chroma
import com.coderusk.dynalibs.rendering.parser.interfaces.ColorParser
import com.coderusk.dynalibs.rendering.renderer.Renderer

object ColorParserImpl : ColorParser {
    override fun parse(input: String, renderer: Renderer): Int {
        return try {
            Color.parseColor(input)
        } catch (e: Exception) {
            smartParseColor(input,renderer.getContext())
        }
    }

    private fun smartParseColor(input: String, context: Context): Int {
        if(input.startsWith("chroma/"))
        {
            var sChroma = input.replace("chroma/","")
            var chroma = Chroma(context)
            var color = chroma.evaluate(sChroma)
            chroma.terminate()
            if(color.isNotEmpty())
            {
                try {
                    return Color.parseColor(color)
                } catch (e: Exception) {

                }
            }
        }

        return Color.BLACK
    }
}