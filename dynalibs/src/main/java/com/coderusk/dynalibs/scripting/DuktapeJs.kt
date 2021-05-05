package com.coderusk.dynalibs.scripting

import com.squareup.duktape.Duktape

class DuktapeJs() {
    companion object{
        val DUKTAPE_IS_NULL_EXCEPTION = "Duktape is null"
    }
    private var duktape: Duktape? = null

    fun create()
    {
        if(duktape==null)
        {
            duktape = Duktape.create()
        }
    }

    fun close()
    {
        duktape?.close()
        duktape = null
    }

    fun evaluate(script: String): Any?
    {
        if(duktape==null)
        {
            create()
        }
        duktape?.let {
            var ret: Any? = null
            try {
                ret = it.evaluate(script)
            } catch (e: Exception) {
                ret = e
            }
            return ret
        }
        return java.lang.Exception(DUKTAPE_IS_NULL_EXCEPTION)
    }

    fun <T>set(name: String, klass: Class<T>, interfaceObject: T): java.lang.Exception?
    {
        if(duktape==null)
        {
            create()
        }
        try {
            duktape?.set(name, klass, interfaceObject)
        } catch (e: Exception) {
            return e
        }
        return null
    }

    fun <T>get(interfaceClass: Class<T>): T?
    {
        if(duktape==null)
        {
            create()
        }
        duktape?.let {
            try {
                return it.get(interfaceClass.simpleName,interfaceClass)
            } catch (e: Exception) {
            }
        }
        return null
    }
}