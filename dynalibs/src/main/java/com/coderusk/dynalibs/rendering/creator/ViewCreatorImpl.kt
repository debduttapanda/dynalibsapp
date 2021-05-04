package com.coderusk.dynalibs.rendering.creator

import android.content.Context
import android.view.View
import android.webkit.WebView
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.airbnb.lottie.LottieAnimationView
import com.coderusk.dynalibs.customViews.AutoImageViewPager
import com.coderusk.dynalibs.customViews.GenericListView
import com.coderusk.dynalibs.customViews.VideoPlayer
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.svg.SVGImageView
import com.google.android.material.navigation.NavigationView
import org.json.JSONObject

object ViewCreatorImpl: ViewCreator {
    override fun create(context: Context, childData: JSONObject, renderer: Renderer): View?
    {
        if(childData.has(F.type))
        {
            try {
                return when(childData.getString(F.type))
                {
                    "VideoPlayer"-> VideoPlayer(context)
                    "Carousel"-> AutoImageViewPager(context)
                    "GenericListView"-> GenericListView(context)
                    "NavigationView"-> NavigationView(context)
                    "DrawerLayout"-> DrawerLayout(context)
                    "FrameLayout"-> FrameLayout(context)
                    "HorizontalScrollView"-> HorizontalScrollView(context)
                    "ScrollView"-> ScrollView(context)
                    "CardView"-> CardView(context)
                    "ConstraintLayout"-> ConstraintLayout(context)
                    "RelativeLayout"-> RelativeLayout(context)
                    "RadioGroup"-> LinearLayout(context)
                    "LinearLayout"-> LinearLayout(context)
                    "ImageView"-> ImageView(context)
                    "SVGImageView"-> SVGImageView(context)
                    "EditText"-> EditText(context)
                    "CheckBox"-> CheckBox(context)
                    "RadioButton"-> RadioButton(context)
                    "Button"-> Button(context)
                    "CheckedTextView"-> CheckedTextView(context)
                    "TextView"-> TextView(context)
                    "WebView"-> WebView(context)
                    "LottieAnimationView"-> LottieAnimationView(context)
                    else->View(context)
                }
            } catch (e: Exception) {
            }
        }
        return null
    }
}