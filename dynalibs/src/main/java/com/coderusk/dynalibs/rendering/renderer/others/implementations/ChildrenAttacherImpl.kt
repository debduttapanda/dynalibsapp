package com.coderusk.dynalibs.rendering.renderer.others.implementations

import android.view.ViewGroup
import com.coderusk.dynalibs.rendering.renderer.ATTACHMENT_TYPE
import com.coderusk.dynalibs.rendering.renderer.others.interfaces.ChildrenAttacher
import com.coderusk.dynalibs.rendering.renderer.others.interfaces.ChildrenComposer

object ChildrenAttacherImpl: ChildrenAttacher {

    override fun attachChildren(parent: ViewGroup, cp: ChildrenComposer, type: ATTACHMENT_TYPE)
    {
        cp.addToParentDirectly(parent)
    }
}