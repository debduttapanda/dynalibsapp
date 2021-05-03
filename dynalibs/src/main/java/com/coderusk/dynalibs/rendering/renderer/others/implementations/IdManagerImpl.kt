package com.coderusk.dynalibs.rendering.renderer.others.implementations

import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.others.interfaces.IdManager
import org.json.JSONArray
import org.json.JSONObject

class IdManagerImpl: IdManager {
    private var idMap = HashMap<String,Int>()
    override fun traverseIds(json: JSONObject) {
        if(json.has(F.children))
        {
            try {
                var childrenData = json.get(F.children) as JSONArray
                var n = childrenData.length()
                for(i in 0 until n)
                {
                    var childData = childrenData[i] as JSONObject
                    if(childData.has(F.id))
                    {
                        var id = childData.getString(F.id)
                        addId(id)
                        traverseIds(childData)

                    }
                }
            } catch (e: Exception) {
            }
        }
    }

    private fun addId(sid: String) {
        if(sid.isNotEmpty())
        {
            if(!idMap.containsKey(sid))
            {
                var id = View.generateViewId()
                idMap[sid] = id
            }
        }
    }
    override fun getId(key: String): Int {
        if(key=="parent"){
            return ConstraintSet.PARENT_ID
        }
        if(idMap.containsKey(key))
        {
            return idMap[key]?:0
        }
        return 0
    }
}