package com.coderusk.dynalibs.rendering.paramrendering.xpr

import com.coderusk.dynalibs.rendering.paramrendering.ParamRendering

object SPR {
    fun create(param: String, action: ((Any)->Unit)?): ParamRendering
    {
        return ParamRendering(param, ParamRendering.Type.STRING,action)
    }
}