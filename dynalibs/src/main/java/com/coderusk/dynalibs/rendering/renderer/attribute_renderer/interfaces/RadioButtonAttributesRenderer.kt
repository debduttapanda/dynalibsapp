package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import android.widget.RadioButton
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface RadioButtonAttributesRenderer {
    fun render(view: RadioButton, attributes: JSONObject, renderer: Renderer)
}