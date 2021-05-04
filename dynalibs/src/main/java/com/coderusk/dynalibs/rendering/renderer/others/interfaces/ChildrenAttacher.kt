package com.coderusk.dynalibs.rendering.renderer.others.interfaces

import android.view.ViewGroup
import com.coderusk.dynalibs.rendering.renderer.ATTACHMENT_TYPE
import com.coderusk.dynalibs.rendering.renderer.Renderer
import org.json.JSONObject

interface ChildrenAttacher {
    fun attachChildren(parent: ViewGroup,
                       cp: ChildrenComposer,
                       type: ATTACHMENT_TYPE = ATTACHMENT_TYPE.REPLACE,
    attachOptions: JSONObject?,
    renderer: Renderer)
}