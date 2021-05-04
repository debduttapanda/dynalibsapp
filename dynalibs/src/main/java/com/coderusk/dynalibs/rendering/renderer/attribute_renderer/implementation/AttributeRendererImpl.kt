package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.view.View
import android.webkit.WebView
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.lottie.LottieAnimationView
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.AttributeRenderer
import com.coderusk.dynalibs.svg.SVGImageView
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
            is WebView->{
                renderer.factory.webViewRenderer.render(view, attributes, renderer)
            }
            is LottieAnimationView->{
                renderer.factory.lottieAnimationViewRenderer.render(view, attributes, renderer)
            }
            is SVGImageView->{
                renderer.factory.svgImageViewRenderer.render(view, attributes, renderer)
            }
            is ImageView->{
                renderer.factory.imageViewRenderer.render(view, attributes, renderer)
            }
            is RadioButton->{
                renderer.factory.radioButtonAttributesRenderer.render(view, attributes, renderer)
            }
            is Button,
            is EditText,
            is TextView ->{
                renderer.factory.textViewAttributesRenderer.render(view as TextView, attributes, renderer)
            }
            else->{
                renderer.factory.viewAttributesRenderer.render(view, attributes, renderer)
            }
        }
    }
}