package com.coderusk.dynalibs.rendering

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ScrollView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.coderusk.dynalibs.customViews.GenericListView
import com.coderusk.dynalibs.rendering.drawable.DrawablesRenderer
import com.coderusk.dynalibs.scripting.AndroidScripting
import com.google.android.material.navigation.NavigationView
import org.json.JSONArray
import org.json.JSONObject

class Renderer(private var context: Activity, var json: JSONObject, var scripting: AndroidScripting)
{
    private var idMap = HashMap<String,Int>()
    init {
        traverseIds(json)
    }

    private fun traverseIds(json: JSONObject) {
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

    class ChildrenComposer(var renderer: Renderer)
    {
        private lateinit var parentClass: Class<*>
        var childrenData: JSONArray? = null
        fun set(parentClass: Class<*>, childrenData: JSONArray) {
            this.parentClass = parentClass
            this.childrenData = childrenData
        }

        fun count(): Int {
            if(childrenData!=null)
            {
                return childrenData!!.length()
            }
            return 0
        }

        fun addToParent(parent: ViewGroup) {
            var n = count()
            if(n>0)
            {
                for(i in 0 until n)
                {
                    try {
                        var childData = childrenData!![i] as JSONObject
                        var view = renderer.renderChild(parentClass,childData)
                        parent.addView(view)
                    } catch (e: Exception) {
                    }
                }
            }
        }

    }
    val validViewGroupClasses = arrayListOf(
            ViewGroup::class.java,
            LinearLayout::class.java,
            RelativeLayout::class.java,
            ConstraintLayout::class.java,
            FrameLayout::class.java,
            ScrollView::class.java,
            CardView::class.java,
            DrawerLayout::class.java,
            NavigationView::class.java,
            GenericListView::class.java,
    )
    private var drawablesRenderer = DrawablesRenderer(context,this)

    fun renderLayout(parentClass: Class<*> = ViewGroup::class.java): ChildrenComposer
    {
        var childrenComposer = ChildrenComposer(this)
        if(!validParentClass(parentClass))
        {
            return childrenComposer
        }
        try {
            updateDrawables(json)
            if(parentClass !is ViewGroup)
            {
                return childrenComposer
            }
            if(json.has(F.children))
            {
                val childrenData = json.getJSONArray(F.children)
                childrenComposer.set(parentClass,childrenData)
            }
            return childrenComposer
        } catch (e: Exception) {
        }
        return childrenComposer
    }

    private fun validParentClass(parentClass: Class<*>): Boolean {
        return validViewGroupClasses.contains(parentClass)
    }

    private fun renderChildren(parentClass: Class<*>, json: JSONObject): ArrayList<View>? {
        if(parentClass !is ViewGroup)
        {
            return null
        }
        if(json.has(F.children))
        {
            val childrenData = json.getJSONArray(F.children)
            val childrenCount = childrenData.length()
            var children = ArrayList<View>()
            for(i in 0 until childrenCount)
            {
                var childData = childrenData[i] as JSONObject
                var child = renderChild(parentClass,childData)
                if(child!=null)
                {
                    children.add(child)
                }
            }
            return children
        }
        return null
    }

    private fun renderChild(parentClass: Class<*>, childData: JSONObject): View? {
        val layoutParams = LayoutParamCreator.create(parentClass)
        LayoutParamRenderer.render(this,layoutParams,childData)
        val view = ViewCreator.create(context,childData)
        if(view==null)
        {
            return null
        }
        view.layoutParams = layoutParams
        if(childData.has(F.attributes))
        {
            var attributes = childData.getJSONObject(F.attributes)
            AttributeRenderer.render(view,attributes, this)
        }
        if(childData.has(F.actions))
        {
            val actions = childData.getJSONArray(F.actions)
            ActionRenderer.render(view,actions)
        }
        var childrenComposer = ChildrenComposer(this)
        if(parentClass !is ViewGroup)
        {
            return view
        }
        if(childData.has(F.children))
        {
            val childrenData = childData.getJSONArray(F.children)
            childrenComposer.set(parentClass,childrenData)
            childrenComposer.addToParent(view as ViewGroup)
        }

        return view
    }

    private fun updateDrawables(j: JSONObject) {
        if(j.has(F.drawables))
        {
            val drawables = j.getJSONArray(F.drawables)
            drawablesRenderer.load(drawables)
        }
    }

    fun getContext(): Context {
        return context
    }

    fun fParse(lw: String): String
    {
        return scripting.fParse(lw)
    }

    fun getId(key: String): Int {
        if(idMap.containsKey(key))
        {
            return idMap[key]?:0
        }
        return 0
    }

    fun getDrawable(did: String): Drawable? {
        return drawablesRenderer.getById(did)
    }
}