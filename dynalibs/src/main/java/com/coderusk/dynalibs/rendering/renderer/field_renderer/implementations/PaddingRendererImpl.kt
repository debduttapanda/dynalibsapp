package com.coderusk.dynalibs.rendering.renderer.field_renderer.implementations

import android.view.View
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces.PaddingRenderer
import org.json.JSONObject

object PaddingRendererImpl: PaddingRenderer {
    override fun render(view: View, attributes: JSONObject, renderer: Renderer){
        var padding = 0
        if(attributes.has(F.padding))
        {
            try {
                var sPadding = attributes.getString(F.padding)
                padding = renderer.factory.dimensionParser.parse(sPadding,renderer)
            } catch (e: Exception) {
            }
        }
        var paddingHorizontal = padding
        if(attributes.has(F.paddingHorizontal))
        {
            try {
                var sPadding = attributes.getString(F.paddingHorizontal)
                paddingHorizontal = renderer.factory.dimensionParser.parse(sPadding,renderer)
            } catch (e: Exception) {
            }
        }
        var paddingVertical = padding
        if(attributes.has(F.paddingVertical))
        {
            try {
                var sPadding = attributes.getString(F.paddingVertical)
                paddingVertical = renderer.factory.dimensionParser.parse(sPadding,renderer)
            } catch (e: Exception) {
            }
        }
        var paddingLeft = paddingHorizontal
        if(attributes.has(F.paddingLeft))
        {
            try {
                var sPadding = attributes.getString(F.paddingLeft)
                paddingLeft = renderer.factory.dimensionParser.parse(sPadding,renderer)
            } catch (e: Exception) {
            }
        }
        var paddingRight = paddingHorizontal
        if(attributes.has(F.paddingRight))
        {
            try {
                var sPadding = attributes.getString(F.paddingRight)
                paddingRight = renderer.factory.dimensionParser.parse(sPadding,renderer)
            } catch (e: Exception) {
            }
        }
        var paddingTop = paddingVertical
        if(attributes.has(F.paddingTop))
        {
            try {
                var sPadding = attributes.getString(F.paddingTop)
                paddingTop = renderer.factory.dimensionParser.parse(sPadding,renderer)
            } catch (e: Exception) {
            }
        }
        var paddingBottom = paddingVertical
        if(attributes.has(F.paddingTop))
        {
            try {
                var sPadding = attributes.getString(F.paddingBottom)
                paddingBottom = renderer.factory.dimensionParser.parse(sPadding,renderer)
            } catch (e: Exception) {
            }
        }
        var paddingStart = -1
        if(attributes.has(F.paddingStart))
        {
            try {
                var sPadding = attributes.getString(F.paddingStart)
                paddingStart = renderer.factory.dimensionParser.parse(sPadding,renderer)
            } catch (e: Exception) {
            }
        }
        var paddingEnd = -1
        if(attributes.has(F.paddingEnd))
        {
            try {
                var sPadding = attributes.getString(F.paddingEnd)
                paddingEnd = renderer.factory.dimensionParser.parse(sPadding,renderer)
            } catch (e: Exception) {
            }
        }
        view.setPadding(paddingLeft,paddingTop,paddingRight,paddingBottom)
        if(paddingStart>-1||paddingEnd>-1)
        {
            if(paddingStart==-1)
            {
                paddingStart = 0
            }
            if(paddingEnd==-1)
            {
                paddingEnd = 0
            }
            view.setPaddingRelative(paddingStart,paddingTop,paddingEnd,paddingBottom)
        }
    }
}