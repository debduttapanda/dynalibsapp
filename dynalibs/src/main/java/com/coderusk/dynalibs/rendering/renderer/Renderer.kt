package com.coderusk.dynalibs.rendering.renderer

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.factory.Factory
import com.coderusk.dynalibs.rendering.renderer.others.interfaces.ChildrenComposer
import com.coderusk.dynalibs.scripting.AndroidScripting
import org.json.JSONObject

class Renderer(private var context: Activity, var json: JSONObject, var scripting: AndroidScripting, var factory: Factory)
{
    private var idManager = factory.getIdManager()
    init {
        idManager.traverseIds(json)
    }
    private var drawablesRenderer = factory.getDrawableRenderer(context,this)

    fun renderLayout(parentClass: Class<*> = ViewGroup::class.java): ChildrenComposer
    {
        var childrenComposer = factory.getChildrenComposer(this)
        if(!validParentClass(parentClass))
        {
            return childrenComposer
        }
        try {
            updateDrawables(json)
            if(json.has(F.children))
            {
                val childrenData = json.getJSONArray(F.children)
                var attachment: JSONObject? = null
                if(json.has(F.attachment))
                {
                    attachment = json.getJSONObject(F.attachment)
                }
                childrenComposer.set(parentClass,childrenData,attachment)
            }
            return childrenComposer
        } catch (e: Exception) {
        }
        return childrenComposer
    }

    private fun validParentClass(parentClass: Class<*>): Boolean {
        return factory.getParentValidator().validate(parentClass)
    }

    fun renderChild(parentClass: Class<*>, childData: JSONObject): View? {
        val layoutParams = factory.getLayoutParamCreator().create(parentClass)
        factory.getLayoutParamRenderer().render(this, layoutParams, childData)
        val view = factory.getViewCreator().create(context, childData)
        if(view==null)
        {
            return null
        }
        view.layoutParams = layoutParams
        if(childData.has(F.attributes))
        {
            var attributes = childData.getJSONObject(F.attributes)
            factory.attributeRenderer.render(view, attributes, this)
        }
        if(childData.has(F.actions))
        {
            val actions = childData.getJSONArray(F.actions)
            factory.actionRenderer.render(view, actions)
        }
        var childrenComposer = factory.getChildrenComposerImpl(this)
        if(validParentClass(parentClass))
        {
            if(childData.has(F.children))
            {
                val childrenData = childData.getJSONArray(F.children)
                var attachment: JSONObject? = null
                if(childData.has(F.attachment))
                {
                    attachment = childData.getJSONObject(F.attachment)
                }
                childrenComposer.set(parentClass,childrenData,attachment)
                factory.childrenAttacher.attachChildren(view as ViewGroup,childrenComposer)
            }
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

        return idManager.getId(key)
    }

    fun getDrawable(did: String): Drawable? {
        return drawablesRenderer.getById(did)
    }
}