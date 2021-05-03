package com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces

import android.view.View
import org.json.JSONObject

interface ScrollIndicatorsRenderer {
    fun render(view: View, attributes: JSONObject)
}