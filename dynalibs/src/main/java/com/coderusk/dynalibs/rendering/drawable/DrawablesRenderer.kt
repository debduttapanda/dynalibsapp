package com.coderusk.dynalibs.rendering.drawable

import android.graphics.drawable.Drawable
import org.json.JSONArray

interface DrawablesRenderer {
    fun getById(did: String): Drawable?
    fun load(drawables: JSONArray)
}