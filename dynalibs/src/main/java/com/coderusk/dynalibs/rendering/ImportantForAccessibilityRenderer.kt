package com.coderusk.dynalibs.rendering

import android.view.View

object ImportantForAccessibilityRenderer {
    fun render(input: String): Int{
        return when(input.toUpperCase()){
            "YES"->View.IMPORTANT_FOR_ACCESSIBILITY_YES
            "NO"->View.IMPORTANT_FOR_ACCESSIBILITY_NO
            "NO_HIDE_DESCENDANTS"->View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS
            else-> View.IMPORTANT_FOR_ACCESSIBILITY_AUTO
        }
    }
}