package com.coderusk.dynalibs.rendering

import android.content.Context
import android.view.View
import android.widget.*
import com.coderusk.dynalibs.SPR
import org.json.JSONObject

object ViewCreator {
    fun create(context: Context, childData: JSONObject): View?
    {
        if(childData.has(F.type))
        {
            try {
                val type = childData.getString(F.type)
                return when(type)
                {
                    "ImageView"-> ImageView(context)
                    "EditText"-> EditText(context)
                    "CheckBox"-> CheckBox(context)
                    "RadioButton"-> RadioButton(context)
                    "Button"-> Button(context)
                    "CheckedTextView"-> CheckedTextView(context)
                    "TextView"-> TextView(context)
                    else->View(context)
                }
            } catch (e: Exception) {
            }
        }
        return null
    }
}