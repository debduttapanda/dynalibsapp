package com.coderusk.dynalibs.rendering

import android.view.View

object ImportantForAutoFillParser {
    fun parse(input: String): Int
    {
        return when(input.toLowerCase()){
            "yes"-> View.IMPORTANT_FOR_AUTOFILL_YES
            "no"-> View.IMPORTANT_FOR_AUTOFILL_NO
            "noExcludeDescendants"-> View.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS
            "yesExcludeDescendants"-> View.IMPORTANT_FOR_AUTOFILL_YES_EXCLUDE_DESCENDANTS
            else-> View.IMPORTANT_FOR_AUTOFILL_AUTO
        }
    }
}