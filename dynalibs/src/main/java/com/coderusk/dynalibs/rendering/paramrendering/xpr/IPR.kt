package com.coderusk.dynalibs.rendering.paramrendering.xpr

import com.coderusk.dynalibs.rendering.paramrendering.ParamRendering

object IPR {
    fun create(param: String, action: ((Any)->Unit)?): ParamRendering
    {
        return ParamRendering(param, ParamRendering.Type.INT,action)
    }
}