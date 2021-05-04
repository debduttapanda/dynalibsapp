package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.content.res.ColorStateList
import android.widget.CompoundButton
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.sGetString
import org.json.JSONObject

object CompoundButtonAttributesRendererImpl : CompoundButtonAttributesRenderer {
    override fun render(view: CompoundButton, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.textViewAttributesRenderer.render(view,attributes,renderer)
        attributes.sGetString(F.button){
            if(it=="@null")
            {
                view.buttonDrawable = null
            }
            else{
                view.buttonDrawable = renderer.getDrawable(it)
            }
        }
        attributes.sGetString(F.buttonTint){
            var color = renderer.factory.colorParser.parse(it,renderer)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                view.buttonTintList= ColorStateList.valueOf(color)
            }
        }
    }
}