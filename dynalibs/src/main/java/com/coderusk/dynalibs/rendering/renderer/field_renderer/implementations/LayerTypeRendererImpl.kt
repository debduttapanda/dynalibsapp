package com.coderusk.dynalibs.rendering.renderer.field_renderer.implementations

import android.view.View
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces.LayerTypeRenderer

object LayerTypeRendererImpl: LayerTypeRenderer {

    override fun render(view: View, input: String, renderer: Renderer)
    {
        view.setLayerType(renderer.factory.layerTypeParser.parse(input),
                renderer.factory.paintParser.parse(null))
    }
}