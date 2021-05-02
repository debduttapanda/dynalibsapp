package com.coderusk.dynalibs.rendering

import android.view.View

object ImportantForContentCaptureParser {
    fun parse(input: String): Int{
        return when(input.toLowerCase()){
            "yes"-> View.IMPORTANT_FOR_CONTENT_CAPTURE_YES
            "no"-> View.IMPORTANT_FOR_CONTENT_CAPTURE_NO
            "noExcludeDescendants"-> View.IMPORTANT_FOR_CONTENT_CAPTURE_NO_EXCLUDE_DESCENDANTS
            "yesExcludeDescendants"-> View.IMPORTANT_FOR_CONTENT_CAPTURE_YES_EXCLUDE_DESCENDANTS
            else-> View.IMPORTANT_FOR_CONTENT_CAPTURE_AUTO
        }
    }
}