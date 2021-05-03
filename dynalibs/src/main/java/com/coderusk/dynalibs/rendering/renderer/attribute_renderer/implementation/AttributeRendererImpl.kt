package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.AttributeRenderer
import com.google.android.material.navigation.NavigationView
import org.json.JSONObject

object AttributeRendererImpl: AttributeRenderer {
    override fun render(view: View, attributes: JSONObject, renderer: Renderer)
    {
        when(view)
        {
            is ScrollView ->{
                renderer.factory.scrollViewAttributesRenderer.render(view, attributes, renderer)
            }
            is CardView ->{
                renderer.factory.cardViewAttributesRenderer.render(view, attributes, renderer)
            }
            is NavigationView ->{
                renderer.factory.navigationViewAttributesRenderer.render(view, attributes, renderer)
            }
            is FrameLayout ->{
                renderer.factory.frameLayoutAttributesRenderer.render(view, attributes, renderer)
            }
            is ConstraintLayout ->{
                renderer.factory.constraintLayoutAttributesRenderer.render(view, attributes, renderer)
            }
            is LinearLayout->{
                renderer.factory.linearLayoutAttributesRenderer.render(view, attributes, renderer)
            }
            is TextView ->{
                renderer.factory.textViewAttributesRenderer.render(view, attributes, renderer)
            }
            else->{
                renderer.factory.viewAttributesRenderer.render(view, attributes, renderer)
            }
        }
    }
}