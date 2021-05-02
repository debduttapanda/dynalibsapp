package com.coderusk.dynalibs.rendering

import android.view.View

object LayerTypeRenderer {

    fun render(view: View, input: String)
    {
        view.setLayerType(LayerTypeParser.parse(input),PaintParser.parse(null)
        )
    }
}