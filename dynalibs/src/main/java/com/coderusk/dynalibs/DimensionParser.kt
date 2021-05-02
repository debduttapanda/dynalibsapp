package com.coderusk.dynalibs

import android.view.ViewGroup
import com.coderusk.dynalibs.rendering.Renderer

object DimensionParser {
    fun parse(layout_width: String, renderer: Renderer): Int
    {
        if(layout_width.startsWith("\$f."))
        {
            var lw = layout_width.replace("\$f.","")
            lw = renderer.fParse(lw)
            return parse(lw,renderer)
        }
        var lw = layout_width.toLowerCase()
        if(lw=="match_parent")
        {
            return ViewGroup.LayoutParams.MATCH_PARENT
        }
        if(lw=="wrap_content")
        {
            return ViewGroup.LayoutParams.WRAP_CONTENT
        }
        if(lw.endsWith("dp"))
        {
            var lw = lw.replace("dp","")
            try {
                var value = lw.toFloat()
                return value.dpToPx(renderer.getContext())
            } catch (e: Exception) {
            }
            try {
                var value = lw.toInt()
                return value.toFloat().dpToPx(renderer.getContext())
            } catch (e: Exception) {
            }
        }
        if(lw.endsWith("sp"))
        {
            var lw = lw.replace("sp","")
            try {
                var value = lw.toFloat()
                return value.spToPx(renderer.getContext())
            } catch (e: Exception) {
            }
            try {
                var value = lw.toInt()
                return value.toFloat().spToPx(renderer.getContext())
            } catch (e: Exception) {
            }
        }
        if(lw.endsWith("sw"))
        {
            var lw = lw.replace("sw","")
            try {
                var value = lw.toFloat()
                return (value*getScreenWidth()).toInt()
            } catch (e: Exception) {
            }
            try {
                var value = lw.toInt()
                return (value*getScreenWidth()).toInt()
            } catch (e: Exception) {
            }
        }
        if(lw.endsWith("sh"))
        {
            var lw = lw.replace("sh","")
            try {
                var value = lw.toFloat()
                return (value*getScreenHeight()).toInt()
            } catch (e: Exception) {
            }
            try {
                var value = lw.toInt()
                return (value* getScreenHeight())
            } catch (e: Exception) {
            }
        }

        return try {
            lw.toInt()
        } catch (e: Exception) {
            0
        }
    }
}