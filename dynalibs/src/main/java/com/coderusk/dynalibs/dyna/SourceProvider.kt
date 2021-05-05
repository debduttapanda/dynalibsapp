package com.coderusk.dynalibs.dyna

import `in`.shrinathbhosale.preffy.Preffy
import android.content.Context
import com.coderusk.dynalibs.R
import com.coderusk.dynalibs.fileString
import com.coderusk.dynalibs.rawString
import java.io.File

class SourceProvider(var context: Context) {
    private var preffy = Preffy.getInstance(context);

    fun get(): String
    {
        try {
            var ini = preffy.getString("initialLayout","")
            if(ini.isNotEmpty())
            {
                var file = File(ini)
                if(file.exists())
                {
                    return ini.fileString()
                }
            }
            return R.raw.initial_default_script_1256.rawString(context)
        } catch (e: Exception) {
        }
        return ""
    }
}