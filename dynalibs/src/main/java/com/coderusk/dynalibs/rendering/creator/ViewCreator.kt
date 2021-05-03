package com.coderusk.dynalibs.rendering.creator

import android.content.Context
import android.view.View
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface ViewCreator {
    fun create(context: Context, childData: JSONObject, renderer: Renderer): View?
}