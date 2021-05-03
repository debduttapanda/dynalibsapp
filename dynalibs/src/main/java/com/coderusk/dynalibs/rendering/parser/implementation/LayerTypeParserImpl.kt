package com.coderusk.dynalibs.rendering.parser.implementation

import android.view.View
import com.coderusk.dynalibs.rendering.parser.interfaces.LayerTypeParser

object LayerTypeParserImpl: LayerTypeParser {
    override fun parse(input: String): Int{
        return when(input.toLowerCase()){
            "hardware"-> View.LAYER_TYPE_HARDWARE
            "software"-> View.LAYER_TYPE_SOFTWARE
            else-> View.LAYER_TYPE_NONE
        }
    }
}