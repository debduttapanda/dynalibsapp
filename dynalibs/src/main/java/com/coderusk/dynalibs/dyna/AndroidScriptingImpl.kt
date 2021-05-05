package com.coderusk.dynalibs.dyna

import com.coderusk.dynalibs.scripting.EvaluationResult
import com.coderusk.dynalibs.scripting.Scripting

class AndroidScriptingImpl(hostApi: HostApi): AndroidScripting {
    private var terminated = false
    private var scripting: Scripting = Scripting()
    private var jsApi: JSApi? = null
    init {
        scripting.setHost("Host", HostApi::class.java,hostApi)
    }

    override fun updateJsApi(script: String)
    {
        if(terminated)
        {
            jsApi = null
            return
        }
        jsApi = scripting.setJsApi(script,"""
            var JSApi = {
                callFor: callFor
            };
        """.trimIndent(), JSApi::class.java)
    }

    override fun evaluate(script: String)
    {
        scripting.evaluate(script)
    }

    override fun evaluateForResult(script: String): EvaluationResult {
        return scripting.evaluateForResult(script)
    }

    override fun callFor(data: String): EvaluationResult
    {
        if(jsApi==null)
        {
            return EvaluationResult(false,"JSApi is null")
        }
        else
        {
            try {
                val result = jsApi?.callFor(data)
                if(result==null)
                {
                    return EvaluationResult(false,"Result is null")
                }
                return EvaluationResult(true,result)
            } catch (e: Exception) {
                return EvaluationResult(false,"${e.message}")
            }
        }
    }

    override fun terminate()
    {
        terminated = true
        scripting.terminate()
    }

    override fun fParse(lw: String): String {
        var er = callFor("""
            {
                "instruction": "fParse",
                "toParse": "$lw"
            }
        """.trimIndent())
        return if(er.success) {
            er.result
        } else {
            ""
        }
    }
}