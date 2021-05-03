package com.coderusk.dynalibs.rendering.renderer.interfaces

import android.view.View
import android.view.ViewGroup
import org.json.JSONArray
import org.json.JSONObject

interface ChildrenComposer {
    fun count(): Int
    fun addToParentDirectly(parent: ViewGroup)
    fun get(index: Int): View?
    fun set(parentClass: Class<*>, childrenData: JSONArray, attachment: JSONObject?)
}