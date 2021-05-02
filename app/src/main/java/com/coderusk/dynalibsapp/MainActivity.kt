package com.coderusk.dynalibsapp

import android.R.attr.name
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.coderusk.dynalibs.*
import com.coderusk.dynalibs.rendering.Renderer
import com.coderusk.dynalibs.scripting.AndroidScripting
import com.coderusk.dynalibs.scripting.HostApi
import com.jsoniter.JsonIterator
import org.json.JSONObject
import org.json.JSONTokener


class MainActivity : AppCompatActivity() {
    var tag = "duktape_testing"
    private lateinit var cl_root: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cl_root = findViewById(R.id.cl_root)
        var scripting = AndroidScripting(object : HostApi {
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
                                        message?.toastShort(this@MainActivity)
                                    }
                                }
                            }
                        }
                    } catch (e: Exception) {
                    }
                }
            }
        })

        scripting.updateJsApi(
            """
            function r(data)
            {
                return JSON.stringify(data);
            }
            function j(data)
            {
                return JSON.parse(data);
            }
            function callFor(data)
            {
                var json = j(data);
                var ins = json.action;
                switch(ins)
                {
                    case "toast":
                    {
                        Host.callback(data);
                        return r({success:true});
                    }
                }
            }
        """.trimIndent()
        )
        scripting.callFor(
            """
            {
                "action": "toast",
                "message": "Hello World"
            }
        """.trimIndent()
        ).result.logd(tag)
        scripting.evaluateForResult("Math.PI").result.logd(tag)
        scripting.terminate()
    }
}