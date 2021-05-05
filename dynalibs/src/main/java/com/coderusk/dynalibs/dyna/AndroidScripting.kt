package com.coderusk.dynalibs.dyna

import com.coderusk.dynalibs.scripting.EvaluationResult

interface AndroidScripting {
    fun updateJsApi(script: String)
    fun evaluate(script: String)
    fun evaluateForResult(script: String): EvaluationResult
    fun callFor(data: String): EvaluationResult
    fun terminate()
    fun fParse(lw: String): String
}