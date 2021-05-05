package com.coderusk.dynalibs.dyna

import android.app.Activity
import androidx.constraintlayout.widget.ConstraintLayout
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.factory.FactoryImpl
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.sGetString
import com.coderusk.dynalibs.toJsonObject
import com.coderusk.dynalibs.toastShort
import org.json.JSONObject

class Dyna(var context: Activity) {
    var sourceProvider = SourceProvider(context)
    private var androidScripting:AndroidScripting = AndroidScriptingImpl(object : HostApi {
        override fun callback(message: String) {
            if (message.isNotEmpty()) {
                try {
                    var json = message.toJsonObject()
                    if (json!!.has("action")) {
                        var action = json.getString("action")
                        when (action) {
                            "toast" -> {
                                if (json.has("message")) {
                                    var message = json.getString("message")
                                    message?.toastShort(context)
                                }
                            }
                        }
                    }
                } catch (e: Exception) {
                }
            }
        }
    })

    init {
        var content = sourceProvider.get()
        androidScripting.updateJsApi(
                """
            $content
        """.trimIndent()
        )
    }

    fun start()
    {
        var er = androidScripting.callFor("""
            {
                "action": "initialLayout"
            }
        """.trimIndent())
        var json = er.result.toJsonObject()
        if(json==null)
        {
            return
        }
        var updatePolicy: JSONObject? = null
        if(json.has(F.updatePolicy)){
            try {
                updatePolicy = json.getJSONObject(F.updatePolicy)
            } catch (e: Exception) {
            }
        }
        var renderer = Renderer(context,json!!,androidScripting, FactoryImpl())
        var cp = renderer.renderLayout(ConstraintLayout::class.java)
        renderer.renderGlobals()
        var n = cp.count()
        if(n>0)
        {
            var v = cp.get(0)
            if(v!=null)
            {
                updatePolicy?.let {
                    updatePolicy.sGetString(F.policy){
                        if(it=="setContentView")
                        {
                            context.setContentView(v)
                        }
                    }
                }

            }
        }
    }
}