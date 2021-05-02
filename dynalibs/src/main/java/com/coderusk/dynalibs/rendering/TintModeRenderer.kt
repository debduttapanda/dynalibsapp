package com.coderusk.dynalibs.rendering

import android.graphics.PorterDuff

object TintModeRenderer {
    fun render(input: String): PorterDuff.Mode
    {
        return when(input.toUpperCase())
        {
            "CLEAR"->PorterDuff.Mode.CLEAR
            "SRC"->PorterDuff.Mode.SRC
            "DST"->PorterDuff.Mode.DST
            "SRC_OVER"->PorterDuff.Mode.SRC_OVER
            "DST_OVER"->PorterDuff.Mode.DST_OVER
            "SRC_IN"->PorterDuff.Mode.SRC_IN
            "DST_IN"->PorterDuff.Mode.DST_IN
            "SRC_OUT"->PorterDuff.Mode.SRC_OUT
            "DST_OUT"->PorterDuff.Mode.DST_OUT
            "SRC_ATOP"->PorterDuff.Mode.SRC_ATOP
            "DST_ATOP"->PorterDuff.Mode.DST_ATOP
            "XOR"->PorterDuff.Mode.XOR
            "DARKEN"->PorterDuff.Mode.DARKEN
            "LIGHTEN"->PorterDuff.Mode.LIGHTEN
            "MULTIPLY"->PorterDuff.Mode.MULTIPLY
            "SCREEN"->PorterDuff.Mode.SCREEN
            "ADD"->PorterDuff.Mode.ADD
            "OVERLAY"->PorterDuff.Mode.OVERLAY
            else->PorterDuff.Mode.SRC
        }
    }
}