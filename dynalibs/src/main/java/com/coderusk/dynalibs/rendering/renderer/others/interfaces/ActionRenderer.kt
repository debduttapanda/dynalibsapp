package com.coderusk.dynalibs.rendering.renderer.others.interfaces

import android.view.View
import org.json.JSONArray

interface ActionRenderer {
    fun render(view: View, actions: JSONArray)
}