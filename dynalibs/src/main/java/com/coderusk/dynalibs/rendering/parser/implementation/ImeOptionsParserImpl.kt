package com.coderusk.dynalibs.rendering.parser.implementation

import android.view.inputmethod.EditorInfo
import com.coderusk.dynalibs.rendering.parser.interfaces.ImeOptionsParser

object ImeOptionsParserImpl : ImeOptionsParser {
    override fun parse(input: String): Int {
        if(!input.contains("|"))
        {
            return singleImeOption(input)
        }
        else
        {
            var parts = input.split("|")
            var num = 0
            for(i in parts.indices)
            {
                var part = parts[i]
                var n = singleImeOption(part)
                num = num or n
            }
            return num
        }
    }

    private fun singleImeOption(it: String): Int {
        return when(it){
            "normal" -> EditorInfo.IME_NULL
            "actionUnspecified" -> EditorInfo.IME_ACTION_UNSPECIFIED
            "actionNone" -> EditorInfo.IME_ACTION_NONE
            "actionGo" -> EditorInfo.IME_ACTION_GO
            "actionSearch" -> EditorInfo.IME_ACTION_SEARCH
            "actionSend" -> EditorInfo.IME_ACTION_SEND
            "actionNext" -> EditorInfo.IME_ACTION_NEXT
            "actionDone" -> EditorInfo.IME_ACTION_DONE
            "actionPrevious" -> EditorInfo.IME_ACTION_PREVIOUS
            "flagForceAscii" -> EditorInfo.IME_FLAG_FORCE_ASCII
            "flagNavigateNext" -> EditorInfo.IME_FLAG_NAVIGATE_NEXT
            "flagNavigatePrevious" -> EditorInfo.IME_FLAG_NAVIGATE_PREVIOUS
            "flagNoAccessoryAction" -> EditorInfo.IME_FLAG_NO_ACCESSORY_ACTION
            "flagNoEnterAction" -> EditorInfo.IME_FLAG_NO_ENTER_ACTION
            "flagNoExtractUi" -> EditorInfo.IME_FLAG_NO_EXTRACT_UI
            "flagNoFullscreen" -> EditorInfo.IME_FLAG_NO_FULLSCREEN
            "flagNoPersonalizedLearning" -> EditorInfo.IME_FLAG_NO_PERSONALIZED_LEARNING
            else-> EditorInfo.IME_NULL
        }

    }
}