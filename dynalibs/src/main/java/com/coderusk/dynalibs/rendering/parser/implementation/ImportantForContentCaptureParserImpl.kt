package com.coderusk.dynalibs.rendering.parser.implementation

import android.view.View
import com.coderusk.dynalibs.rendering.parser.interfaces.ImportantForContentCaptureParser

object ImportantForContentCaptureParserImpl: ImportantForContentCaptureParser {
    override fun parse(input: String): Int{
        return when(input.toLowerCase()){
            "yes"-> View.IMPORTANT_FOR_CONTENT_CAPTURE_YES
            "no"-> View.IMPORTANT_FOR_CONTENT_CAPTURE_NO
            "noExcludeDescendants"-> View.IMPORTANT_FOR_CONTENT_CAPTURE_NO_EXCLUDE_DESCENDANTS
            "yesExcludeDescendants"-> View.IMPORTANT_FOR_CONTENT_CAPTURE_YES_EXCLUDE_DESCENDANTS
            else-> View.IMPORTANT_FOR_CONTENT_CAPTURE_AUTO
        }
    }
}