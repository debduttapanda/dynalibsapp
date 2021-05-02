package com.coderusk.dynalibs.rendering

import android.view.View
import org.json.JSONArray
import org.json.JSONObject

object AttributeRenderer {
    fun render(view: View, attributes: JSONObject, renderer: Renderer)
    {
        when(view)
        {
            else->{
                ViewAttributesRenderer.render(view,attributes, renderer)
            }
        }
    }
}