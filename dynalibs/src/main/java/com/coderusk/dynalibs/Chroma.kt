package com.coderusk.dynalibs

import android.content.Context
import com.coderusk.dynalibs.scripting.DuktapeJs

class Chroma(var context: Context) {
    private var duktape = DuktapeJs()
    init {
        duktape.evaluate(R.raw.chroma.rawString(context))
    }
    fun terminate()
    {
        duktape.close()
    }

    fun evaluate(input: String): String
    {
        return try {
            duktape.evaluate(input) as String
        } catch (e: Exception) {
            ""
        }
    }
}