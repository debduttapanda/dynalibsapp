package com.coderusk.dynalibs.rendering.renderer.others.implementations

import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.coderusk.dynalibs.customViews.GenericListView
import com.coderusk.dynalibs.rendering.renderer.others.interfaces.ViewGroupTypeValidator
import com.google.android.material.navigation.NavigationView

object ViewGroupTypeValidatorImpl: ViewGroupTypeValidator {
    val validViewGroupClasses = arrayListOf(
            ViewGroup::class.java,
            LinearLayout::class.java,
            RelativeLayout::class.java,
            ConstraintLayout::class.java,
            FrameLayout::class.java,
            ScrollView::class.java,
            HorizontalScrollView::class.java,
            CardView::class.java,
            DrawerLayout::class.java,
            NavigationView::class.java,
            GenericListView::class.java,
    )
    override fun validate(parentClass: Class<*>): Boolean {
        return validViewGroupClasses.contains(parentClass)
    }
}