package com.coderusk.dynalibs.rendering.renderer.others.implementations

import android.view.ViewGroup
import com.coderusk.dynalibs.customViews.GenericListView
import com.coderusk.dynalibs.rendering.renderer.ATTACHMENT_TYPE
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.others.interfaces.ChildrenAttacher
import com.coderusk.dynalibs.rendering.renderer.others.interfaces.ChildrenComposer
import org.json.JSONObject

object ChildrenAttacherImpl: ChildrenAttacher {
    override fun attachChildren(parent: ViewGroup,
                                cp: ChildrenComposer,
                                type: ATTACHMENT_TYPE,
                                attachOptions: JSONObject?,
                                renderer: Renderer)
    {
        if(parent is GenericListView)
        {
            renderer.factory.glvChildrenAttacher.attach(parent,cp,type,attachOptions,renderer)
            return
        }
        cp.addToParentDirectly(parent)
    }
}