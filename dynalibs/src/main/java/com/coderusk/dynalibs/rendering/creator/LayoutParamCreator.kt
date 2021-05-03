package com.coderusk.dynalibs.rendering.creator

import android.view.ViewGroup

interface LayoutParamCreator {
    fun create(parentClass: Class<*>): ViewGroup.LayoutParams
}