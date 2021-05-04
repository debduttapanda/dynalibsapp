package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import android.widget.CheckBox
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface CheckBoxAttributesRenderer {
    fun render(view: CheckBox, attributes: JSONObject, renderer: Renderer)
}