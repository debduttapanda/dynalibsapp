package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces

import com.coderusk.dynalibs.customViews.AutoImageViewPager
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface AutoImageViewPagerAttributesRenderer {
    fun render(view: AutoImageViewPager, attributes: JSONObject, renderer: Renderer)
}