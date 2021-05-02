package com.coderusk.dynalibs.scripting

class AndroidScripting(hostApi: HostApi) {
    private var terminated = false
    private var scripting: Scripting = Scripting()
    private var jsApi: JSApi? = null
    init {
        scripting.setHost("Host",HostApi::class.java,hostApi)
    }

    fun updateJsApi(script: String)
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

    fun evaluate(script: String)
    {
        scripting.evaluate(script)
    }

    fun evaluateForResult(script: String): Scripting.EvaluationResult {
        return scripting.evaluateForResult(script)
    }

    fun callFor(data: String): Scripting.EvaluationResult
    {
        if(jsApi==null)
        {
            return Scripting.EvaluationResult(false,"JSApi is null")
        }
        else
        {
            try {
                val result = jsApi?.callFor(data)
                if(result==null)
                {
                    return Scripting.EvaluationResult(false,"Result is null")
                }
                return Scripting.EvaluationResult(true,result)
            } catch (e: Exception) {
                return Scripting.EvaluationResult(false,"${e.message}")
            }
        }
    }

    fun terminate()
    {
        terminated = true
        scripting.terminate()
    }

    fun fParse(lw: String): String {
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