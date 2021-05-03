package com.coderusk.dynalibs.scripting

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.coderusk.dynalibs.scripting.DuktapeJs
import java.lang.Exception

class Scripting() {
    val DATA_TYPE_IS_NOT_STRING = "Data type is not string"
    private var loadCount = 0

    private var terminated = false
    private var duktapeJs = DuktapeJs()
    init {

    }
    fun <T>setJsApi(script: String, jsApiScript: String, interfaceClass: Class<T>): T?
    {
        if(terminated)
        {
            return null
        }
        ++loadCount
        if(loadCount>1)
        {
            duktapeJs.close()
            duktapeJs = DuktapeJs()
        }
        duktapeJs.evaluate(script)
        duktapeJs.evaluate(jsApiScript)
        return duktapeJs.get(interfaceClass)
    }

    fun addScript(script: String)
    {
        evaluate(script)
    }

    fun evaluate(script: String)
    {
        if(terminated)
        {
            return
        }
        duktapeJs.evaluate(script)
    }

    fun evaluateForResult(script: String): EvaluationResult
    {
        val result = duktapeJs.evaluate(script)
        if(result is Exception)
        {
            return EvaluationResult(false,"${result.message}")
        }
        if(result==null)
        {
            return EvaluationResult(false,"Result is null")
        }
        return EvaluationResult(true,result.toString())
    }

    fun <T>setHost(name: String, klass: Class<T>, interfaceObject: T)
    {
        if(terminated)
        {
            return
        }
        duktapeJs.set(name,klass,interfaceObject)
    }

    fun terminate()
    {
        terminated = true
        duktapeJs.close()
    }
}