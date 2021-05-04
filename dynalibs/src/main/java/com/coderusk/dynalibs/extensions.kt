package com.coderusk.dynalibs

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.util.TypedValue
import android.widget.Toast
import com.coderusk.dynalibs.rendering.paramrendering.xpr.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream


fun String.logd(tag: String)
{
    Log.d(tag, this)
}

fun String.toastShort(context: Context)
{
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun String.toastLong(context: Context)
{
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}

fun String.toJsonObject(): JSONObject?
{
    try {
        return JSONObject(this)
    } catch (e: Exception) {
    }
    return null
}

fun getRawResource(context: Context, resource: Int): String {
    var res= ""
    val `is`: InputStream = context.resources.openRawResource(resource)
    val baos = ByteArrayOutputStream()
    val b = ByteArray(1)
    try {
        while (`is`.read(b) !== -1) {
            baos.write(b)
        }
        res = baos.toString()
        `is`.close()
        baos.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return res
}

fun Int.rawString(context: Context): String
{
    return getRawResource(context, this)
}

fun Any.millis(): Long {
    return System.currentTimeMillis()
}

fun dpToPx(context: Context, measure: Float): Int {
    val r = context.resources
    val px =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, measure, r.displayMetrics)
    return px.toInt()
}

fun Float.dpToPx(context: Context): Int
{
    return dpToPx(context, this)
}

fun spToPx(context: Context, sp: Float): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP, sp, context.resources.displayMetrics
    ).toInt()
}

fun Float.spToPx(context: Context): Int
{
    return spToPx(context, this)
}

fun getScreenWidth(): Int
{
    return Resources
        .getSystem()
        .displayMetrics
        .widthPixels
}

fun getScreenHeight(): Int
{
    return Resources
        .getSystem()
        .displayMetrics
        .heightPixels
}

fun JSONObject.BPR(param: String, action: ((Any)->Unit)?)
{
    BPR.create(param,action).execute(this)
}

fun JSONObject.SPR(param: String, action: ((Any)->Unit)?)
{
    SPR.create(param,action).execute(this)
}

fun JSONObject.OPR(param: String, action: ((Any)->Unit)?)
{
    OPR.create(param,action).execute(this)
}

fun JSONObject.APR(param: String, action: ((Any)->Unit)?)
{
    APR.create(param,action).execute(this)
}

fun JSONObject.FPR(param: String, action: ((Any)->Unit)?)
{
    FPR.create(param,action).execute(this)
}

fun JSONObject.IPR(param: String, action: ((Any)->Unit)?)
{
    IPR.create(param,action).execute(this)
}

fun JSONObject.sGetBoolean(key: String, callback: (Boolean) -> Unit)
{
    try {
        if(this.has(key))
        {
            var value = this.getBoolean(key)
            callback(value)
        }
    } catch (e: Exception) {
    }
}
/*fun String.toColor(): Int{
    return try {
        Color.parseColor(this)
    } catch (e: Exception) {
        Color.BLACK
    }
}*/
/*fun JSONObject.sGetColor(key: String, callback: (Int) -> Unit)
{
    try {
        if(this.has(key))
        {
            var value = this.getString(key).toColor()
            callback(value)
        }
    } catch (e: Exception) {
    }
}*/

fun JSONObject.sGetInt(key: String, callback: (Int) -> Unit)
{
    try {
        if(this.has(key))
        {
            callback(this.getInt(key))
        }
    } catch (e: Exception) {
    }
}

fun JSONObject.sGetString(key: String, callback: (String) -> Unit)
{
    try {
        if(this.has(key))
        {
            callback(this.getString(key))
        }
    } catch (e: Exception) {
    }
}

fun JSONObject.sGetFloat(key: String, callback: (Float) -> Unit)
{
    try {
        if(this.has(key))
        {
            callback(this.getDouble(key).toFloat())
        }
    } catch (e: Exception) {
    }
}

fun JSONObject.sGetJsonArray(key: String, callback: (JSONArray) -> Unit)
{
    try {
        if(this.has(key))
        {
            callback(this.getJSONArray(key))
        }
    } catch (e: Exception) {
    }
}

fun JSONObject.sGetJsonObject(key: String, callback: (JSONObject) -> Unit)
{
    try {
        if(this.has(key))
        {
            callback(this.getJSONObject(key))
        }
    } catch (e: Exception) {
    }
}

fun JSONObject.sGetIntArray(key: String, callback: (IntArray) -> Unit)
{
    try {
        if(this.has(key))
        {
            var value = this.getString(key)
            if(value.contains(" "))
            {
                var parts = value.split(" ")
                var d= parts.map {
                    it.toInt()
                }
                callback(d.toIntArray())
            }
            else
            {
                callback(listOf(value.toInt()).toIntArray())
            }
        }
    } catch (e: Exception) {
    }
}

fun JSONObject.sGetFloatArray(key: String, callback: (FloatArray) -> Unit)
{
    try {
        if(this.has(key))
        {
            var value = this.getString(key)
            if(value.contains(" "))
            {
                var parts = value.split(" ")
                var d= parts.map {
                    it.toFloat()
                }
                callback(d.toFloatArray())
            }
            else
            {
                callback(listOf(value.toFloat()).toFloatArray())
            }
        }
    } catch (e: Exception) {
    }
}

fun JSONObject.sGetStringArray(key: String, callback: (List<String>) -> Unit)
{
    try {
        if(this.has(key))
        {
            var value = this.getString(key)
            if(value.contains(" "))
            {
                var parts = value.split(" ")
                callback(parts)
            }
            else
            {
                callback(listOf(value))
            }
        }
    } catch (e: Exception) {
    }
}

fun String.spacePart(part: Int): String{
    if(part>-1)
    {
        if(this.contains(" "))
        {
            var parts = this.split(" ")
            if(parts.size>part)
            {
                return parts[part]
            }
        }
    }
    return ""
}

fun String.commaParts(): List<String>{
    if(this.contains(","))
    {
        return split(",")
    }
    return List(0){""}
}

fun List<String>.toFloatArray():FloatArray
{
    var arr = FloatArray(this.size)
    for(i in this.indices)
    {
        var item = this[i]
        try {
            arr[i] = item.toFloat()
        } catch (e: Exception) {
        }
    }
    return arr
}

