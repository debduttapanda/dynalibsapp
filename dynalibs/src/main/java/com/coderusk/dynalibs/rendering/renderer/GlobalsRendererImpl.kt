package com.coderusk.dynalibs.rendering.renderer

import android.app.Activity
import android.content.Context
import android.view.WindowManager
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.sGetJsonObject
import com.coderusk.dynalibs.sGetString
import org.json.JSONObject

object GlobalsRendererImpl : GlobalsRenderer {
    override fun render(json: JSONObject, renderer: Renderer) {
        json.sGetJsonObject(F.globals){globals->
            globals.sGetString(F.statusBarColor){scolor->
                setStatusBarColor(renderer.getContext(),renderer.factory.colorParser.parse(scolor,renderer))
            }

        }
    }

    private fun setStatusBarColor(context: Context, toColor: Int) {
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            try {
                var window = (context as Activity).window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.statusBarColor = toColor;
            } catch (e: Exception) {
            }
        }
    }
}