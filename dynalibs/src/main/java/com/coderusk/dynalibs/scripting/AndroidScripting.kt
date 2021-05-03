package com.coderusk.dynalibs.scripting

interface AndroidScripting {
    fun updateJsApi(script: String)
    fun evaluate(script: String)
    fun evaluateForResult(script: String): EvaluationResult
    fun callFor(data: String): EvaluationResult
    fun terminate()
    fun fParse(lw: String): String
}