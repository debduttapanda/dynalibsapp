package com.coderusk.dynalibs.rendering.renderer.others.interfaces

import com.coderusk.dynalibs.customViews.GenericListView
import com.coderusk.dynalibs.rendering.renderer.ATTACHMENT_TYPE
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface GlvChildrenAttacher {
    fun attach(parent: GenericListView,
               cp: ChildrenComposer,
               type: ATTACHMENT_TYPE,
               attachOptions: JSONObject?,
               renderer: Renderer)
}