package com.coderusk.dynalibs.rendering

import android.view.View

object LayerTypeParser {
    fun parse(input: String): Int{
        return when(input.toLowerCase()){
            "hardware"-> View.LAYER_TYPE_HARDWARE
            "software"-> View.LAYER_TYPE_SOFTWARE
            else-> View.LAYER_TYPE_NONE
        }
    }
}