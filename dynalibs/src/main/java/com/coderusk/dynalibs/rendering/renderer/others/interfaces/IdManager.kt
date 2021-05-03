package com.coderusk.dynalibs.rendering.renderer.others.interfaces

import org.json.JSONObject

interface IdManager {
    fun traverseIds(json: JSONObject)
    fun getId(key: String): Int
}