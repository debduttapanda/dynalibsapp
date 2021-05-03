package com.coderusk.dynalibs.rendering.creator

import android.content.Context
import android.view.View
import org.json.JSONObject

interface ViewCreator {
    fun create(context: Context, childData: JSONObject): View?
}