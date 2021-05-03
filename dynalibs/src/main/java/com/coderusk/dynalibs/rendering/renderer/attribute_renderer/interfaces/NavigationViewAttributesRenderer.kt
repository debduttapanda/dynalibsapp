package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.google.android.material.navigation.NavigationView
import org.json.JSONObject

interface NavigationViewAttributesRenderer {
    fun render(view: NavigationView, attributes: JSONObject, renderer: Renderer)
}