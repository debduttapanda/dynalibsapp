package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.widget.CompoundButton
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface CompoundButtonAttributesRenderer {
    fun render(view: CompoundButton, attributes: JSONObject, renderer: Renderer)
}