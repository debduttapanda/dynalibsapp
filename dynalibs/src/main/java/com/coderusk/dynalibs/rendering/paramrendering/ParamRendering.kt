package com.coderusk.dynalibs.rendering.paramrendering

import org.json.JSONObject

class ParamRendering(
    private var param: String = "",
    private var type: Type = Type.UNKNOWN,
    private var action: ((Any) -> Unit)? = null
) {
    enum class Type
    {
        STRING,
        INT,
        BOOLEAN,
        FLOAT,
        OBJECT,
        ARRAY,
        UNKNOWN
    }

    fun execute(input: JSONObject)
    {
        if(param.isNotEmpty())
        {
            if(input.has(param))
            {
                var paramValue = get(input,param,type)
                if(paramValue!=null)
                {
                    action?.let {
                        try {
                            it(paramValue)
                        } catch (e: Exception) {
                        }
                    }
                }
            }
        }
    }

    private fun get(input: JSONObject, param: String, type: Type): Any? {
        try {
            if(param.isEmpty())
            {
                return null
            }
            if(!input.has(param))
            {
                return null
            }
            return when(type)
            {
                Type.STRING ->input.getString(param)
                Type.INT ->input.getInt(param)
                Type.BOOLEAN ->input.getBoolean(param)
                Type.FLOAT ->input.getDouble(param).toFloat()
                Type.OBJECT ->input.getJSONObject(param)
                Type.ARRAY ->input.getJSONArray(param)
                Type.UNKNOWN ->null
            }
        } catch (e: Exception) {
        }
        return null
    }
}