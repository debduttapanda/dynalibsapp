package com.coderusk.dynalibs.rendering.parser.implementation

import android.view.View
import com.coderusk.dynalibs.rendering.parser.interfaces.ImportantForAccessibilityParser

object ImportantForAccessibilityParserImpl: ImportantForAccessibilityParser {
    override fun parser(input: String): Int{
        return when(input.toUpperCase()){
            "YES"->View.IMPORTANT_FOR_ACCESSIBILITY_YES
            "NO"->View.IMPORTANT_FOR_ACCESSIBILITY_NO
            "NO_HIDE_DESCENDANTS"-> if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS
            } else {
                View.IMPORTANT_FOR_ACCESSIBILITY_AUTO
            }
            else-> View.IMPORTANT_FOR_ACCESSIBILITY_AUTO
        }
    }
}