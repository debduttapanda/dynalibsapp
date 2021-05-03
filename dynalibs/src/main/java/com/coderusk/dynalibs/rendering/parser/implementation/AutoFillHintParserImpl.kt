package com.coderusk.dynalibs.rendering.parser.implementation

import android.view.View
import com.coderusk.dynalibs.rendering.parser.interfaces.AutoFillHintParser

object AutoFillHintParserImpl: AutoFillHintParser {
    override fun parse(s: String): ArrayList<String>
    {
        var autoFills = ArrayList<String>()
        if(s.isNotEmpty())
        {
            if(!s.contains(","))
            {
                autoFills.add(singleAutoFillHint(s))
            }
            else
            {
                var parts = s.split(",")
                var count = parts.size
                for(i in 0 until count)
                {
                    var part = parts[i]
                    var autoFill = singleAutoFillHint(part)
                    if(autoFill.isNotEmpty())
                    {
                        autoFills.add(autoFill)
                    }
                }
            }
        }
        return autoFills
    }

    private fun singleAutoFillHint(s: String): String {
        return when(s.toUpperCase())
        {
            "USERNAME"-> View.AUTOFILL_HINT_USERNAME
            "EMAIL"-> View.AUTOFILL_HINT_EMAIL_ADDRESS
            "NAME"-> View.AUTOFILL_HINT_NAME
            "PHONE"-> View.AUTOFILL_HINT_PHONE
            "POSTAL_ADDRESS"-> View.AUTOFILL_HINT_POSTAL_ADDRESS
            "POSTAL_CODE"-> View.AUTOFILL_HINT_POSTAL_CODE
            "CREDIT_CARD_NUMBER"-> View.AUTOFILL_HINT_CREDIT_CARD_NUMBER
            "CREDIT_CARD_SECURITY_CODE"-> View.AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE
            "CREDIT_CARD_EXPIRATION_DATE"-> View.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE
            "CREDIT_CARD_EXPIRATION_DAY"-> View.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY
            "CREDIT_CARD_EXPIRATION_MONTH"-> View.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH
            "CREDIT_CARD_EXPIRATION_YEAR"-> View.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR
            else->""
        }
    }
}