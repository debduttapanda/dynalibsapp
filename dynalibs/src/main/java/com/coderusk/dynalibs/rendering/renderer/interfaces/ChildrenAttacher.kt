package com.coderusk.dynalibs.rendering.renderer.interfaces

import android.view.ViewGroup
import com.coderusk.dynalibs.rendering.renderer.ATTACHMENT_TYPE

interface ChildrenAttacher {
    fun attachChildren(parent: ViewGroup, cp: ChildrenComposer, type: ATTACHMENT_TYPE = ATTACHMENT_TYPE.REPLACE)
}