package com.coderusk.dynalibs.rendering.parser.implementation

import android.view.Gravity
import androidx.core.view.GravityCompat
import com.coderusk.dynalibs.rendering.parser.interfaces.GravityParser

object GravityParserImpl: GravityParser {
    override fun parse(layout_gravity: String): Int
    {
        if(!layout_gravity.contains("|"))
        {
            var g = composeSingleGravity(layout_gravity)
            return g
        }
        else
        {
            var parts = layout_gravity.split("|")
            var count = parts.size
            var g = Gravity.NO_GRAVITY
            for(i in 0 until count)
            {
                var part = parts[i]
                g  = g or composeSingleGravity(part)
            }
            return g
        }
    }

    private fun composeSingleGravity(gravity: String): Int {
        when(gravity.toUpperCase())
        {
            "NO_GRAVITY" -> {
                return Gravity.NO_GRAVITY
            }
            "TOP" -> {
                return Gravity.TOP
            }
            "BOTTOM" -> {
                return Gravity.BOTTOM
            }
            "LEFT" -> {
                return Gravity.LEFT
            }
            "RIGHT" -> {
                return Gravity.RIGHT
            }
            "CENTER_VERTICAL" -> {
                return Gravity.CENTER_VERTICAL
            }
            "FILL_VERTICAL" -> {
                return Gravity.FILL_VERTICAL
            }
            "CENTER_HORIZONTAL" -> {
                return Gravity.CENTER_HORIZONTAL
            }
            "FILL_HORIZONTAL" -> {
                return Gravity.FILL_HORIZONTAL
            }
            "CENTER" -> {
                return Gravity.CENTER
            }
            "FILL" -> {
                return Gravity.FILL
            }
            "START" -> {
                return Gravity.START
            }
            "COMPATSTART" -> {
                return GravityCompat.START
            }
            "END" -> {
                return Gravity.END
            }
            else->{
                return Gravity.NO_GRAVITY
            }
        }
    }
}