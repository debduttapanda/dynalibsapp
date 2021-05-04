package com.coderusk.dynalibs.rendering.renderer.others.implementations

import android.view.View
import android.view.ViewGroup
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.others.interfaces.ChildrenComposer
import org.json.JSONArray
import org.json.JSONObject

class ChildrenComposerImpl(var renderer: Renderer): ChildrenComposer
    {
        private lateinit var parentClass: Class<*>
        var childrenData: JSONArray? = null
        var attachment: JSONObject? = null
        override fun set(parentClass: Class<*>, childrenData: JSONArray, attachment: JSONObject?) {
            this.attachment = attachment
            this.parentClass = parentClass
            this.childrenData = childrenData
        }

        override fun count(): Int {
            if(childrenData!=null)
            {
                return childrenData!!.length()
            }
            return 0
        }

        override fun addToParentDirectly(parent: ViewGroup) {
            var n = count()
            if(n>0)
            {
                for(i in 0 until n)
                {
                    try {
                        val childData = childrenData!![i] as JSONObject
                        val view = renderer.renderChild(parent.javaClass,childData)
                        parent.addView(view)
                    } catch (e: Exception) {
                    }
                }
            }
        }

        override fun get(index: Int): View?
        {
            if(index>=count()){
                return null
            }
            if(childrenData==null)
            {
                return null
            }
            val childData = childrenData!![index] as JSONObject
            return renderer.renderChild(parentClass,childData)
        }

    }