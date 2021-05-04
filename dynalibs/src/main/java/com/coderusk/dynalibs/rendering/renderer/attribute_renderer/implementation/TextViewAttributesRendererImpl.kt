package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.graphics.drawable.Drawable
import android.widget.TextView
import com.coderusk.dynalibs.*
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.TextViewAttributesRenderer
import org.json.JSONObject

object TextViewAttributesRendererImpl: TextViewAttributesRenderer {
    override fun render(view: TextView, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.viewAttributesRenderer.render(view, attributes, renderer)
        attributes.sGetString(F.movementMethod){
            view.movementMethod = renderer.factory.movementMethodParser.parse(it)
        }

        attributes.sGetString(F.focusable)
        {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.focusable = renderer.factory.focusableParser.parse(it,renderer)
            }
        }

        attributes.sGetString(F.autoLinkMask){
            view.autoLinkMask = renderer.factory.autoLinkMaskParser.parse(it,renderer)
        }
        attributes.sGetStringArray(F.autoSizeTextTypeUniformWithConfiguration){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                if(it.size==4)
                {
                    view.setAutoSizeTextTypeUniformWithConfiguration(
                            renderer.factory.dimensionParser.parse(it[0],renderer),
                            renderer.factory.dimensionParser.parse(it[1],renderer),
                            renderer.factory.dimensionParser.parse(it[2],renderer),
                            renderer.factory.dimensionParser.parse(it[3],renderer)
                    )
                }

            }
        }
        attributes.sGetStringArray(F.autoSizeTextTypeUniformWithPresetSizes){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                if(it.size>1)
                {
                    var arrCount = it.size - 1
                    var arr = it.subList(0, arrCount - 1) as List<Int>
                    view.setAutoSizeTextTypeUniformWithPresetSizes(
                            arr.toIntArray(),
                            renderer.factory.dimensionParser.parse(it[arrCount],renderer)
                    )
                }
            }
        }
        attributes.sGetString(F.autoSizeTextType){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.setAutoSizeTextTypeWithDefaults(
                        renderer.factory.autoSizeTextTypeWidthDefaultsParser.parse(it)
                )
            }
        }
        attributes.sGetString(F.breakStrategy){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                view.breakStrategy = renderer.factory.breakStrategyParser.parse(it)
            }
        }
        attributes.sGetBoolean(F.cursorVisible){
            view.isCursorVisible = it
        }
        setupTextViewSideDrawables(view, attributes,renderer)
        attributes.sGetString(F.drawablePadding){
            view.compoundDrawablePadding = renderer.factory.dimensionParser.parse(it,renderer)
        }
        attributes.sGetString(F.ellipsize){
            view.ellipsize = renderer.factory.ellipsizeParser.parse(it)
        }
        attributes.sGetString(F.hint){
            view.hint = it
        }
        attributes.sGetString(F.hyphenationFrequency){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                view.hyphenationFrequency = renderer.factory.hyphenationFrequencyParser.parse(it)
            }
        }
        attributes.sGetString(F.imeOptions){
            view.imeOptions = renderer.factory.imeOptionsParser.parse(it)
        }
        attributes.sGetString(F.inputType){
            view.inputType = renderer.factory.inputTypeParser.parse(it)
        }
        attributes.sGetString(F.justificationMode){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.justificationMode = renderer.factory.justificationModeParser.parse(it)
            }
        }
        attributes.sGetFloat(F.letterSpacing){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                view.letterSpacing = it
            }
        }
        attributes.sGetString(F.lastBaselineToBottomHeight){
            view.lastBaselineToBottomHeight = renderer.factory.dimensionParser.parse(it,renderer)
        }
        attributes.sGetString(F.lineHeight){
            view.lineHeight = renderer.factory.dimensionParser.parse(it,renderer)
        }

        attributes.sGetStringArray(F.lineSpacing){
            if(it.size==2)
            {
                view.setLineSpacing(
                        renderer.factory.dimensionParser.parse(it[0],renderer).toFloat(),
                        renderer.factory.dimensionParser.parse(it[1],renderer).toFloat()
                )
            }
        }
        attributes.sGetInt(F.lines){
            view.setLines(it)
        }
        attributes.sGetBoolean(F.linksClickable){
            view.linksClickable = it
        }
        attributes.sGetInt(F.marqueeLimit){
            view.marqueeRepeatLimit = it
        }
        attributes.sGetInt(F.maxEms){
            view.maxEms = it
        }
        attributes.sGetString(F.maxHeight){
            view.maxHeight = renderer.factory.dimensionParser.parse(it,renderer)
        }
        attributes.sGetInt(F.maxLines){
            view.maxLines = it
        }
        attributes.sGetString(F.maxWidth){
            view.maxWidth = renderer.factory.dimensionParser.parse(it,renderer)
        }
        attributes.sGetInt(F.minEms){
            view.minEms = it
        }
        attributes.sGetString(F.minHeight){
            view.minHeight = renderer.factory.dimensionParser.parse(it,renderer)
        }
        attributes.sGetInt(F.minLines){
            view.minLines = it
        }
        attributes.sGetString(F.minWidth){
            view.minWidth = renderer.factory.dimensionParser.parse(it,renderer)
        }
        attributes.sGetInt(F.scrollHorizontally){
            view.canScrollHorizontally(it)
        }
        attributes.sGetBoolean(F.selectAllOnFocus){
            view.setSelectAllOnFocus(it)
        }
        attributes.sGetStringArray(F.shadowLayer){ shadowLayer->
            if(shadowLayer.size==4)
            {
                view.setShadowLayer(
                        shadowLayer[0].toFloat(),
                        shadowLayer[1].toFloat(),
                        shadowLayer[2].toFloat(),
                        renderer.factory.colorParser.parse(shadowLayer[3],renderer)
                )
            }
        }
        attributes.sGetBoolean(F.singleLine){
            view.isSingleLine = it
        }
        renderer.factory.textRenderer.render(view,attributes,renderer)
        attributes.sGetBoolean(F.isAllCaps){
            view.isAllCaps = it
        }
        attributes.sGetString(F.textColor){
            view.setTextColor(renderer.factory.colorParser.parse(it,renderer))
        }
        attributes.sGetString(F.highlightColor){
            view.highlightColor =renderer.factory.colorParser.parse(it,renderer)
        }
        attributes.sGetString(F.hintColor){
            view.setHintTextColor(renderer.factory.colorParser.parse(it,renderer))
        }
        attributes.sGetString(F.linkColor){
            view.setLinkTextColor(renderer.factory.colorParser.parse(it,renderer))
        }
        attributes.sGetString(F.cursorDrawable){ str->
            val d = renderer.getDrawable(str)
            if(d!=null)
            {
                view.textCursorDrawable = d
            }
        }
        attributes.sGetBoolean(F.textIsSelectable){
            view.setTextIsSelectable(false)
        }
        attributes.sGetFloat(F.textScaleX){
            view.textScaleX = it
        }
        attributes.sGetString(F.textSelectHandle){ str ->
            var d = renderer.getDrawable(str)
            if(d!=null)
            {
                view.setTextSelectHandle(d)
            }
        }
        attributes.sGetString(F.textSelectHandleLeft){ str ->
            var d = renderer.getDrawable(str)
            if(d!=null)
            {
                view.setTextSelectHandleLeft(d)
            }
        }
        attributes.sGetString(F.textSelectHandleRight){ str ->
            var d = renderer.getDrawable(str)
            if(d!=null)
            {
                view.setTextSelectHandleRight(d)
            }
        }
        attributes.sGetFloat(F.textSize){
            view.textSize = it
        }
        attributes.sGetString(F.textStyle){
            view.setTypeface(null, renderer.factory.textStyleParser.parse(it))
        }
        attributes.sGetString(F.width){
            view.width = renderer.factory.dimensionParser.parse(it,renderer)
        }
        attributes.sGetString(F.gravity){
            view.gravity = renderer.factory.gravityParser.parse(it)
        }
    }
    private fun setupTextViewSideDrawables(view: TextView, attributes: JSONObject, renderer: Renderer) {
        var drawableBottom: Drawable? = null
        var drawableTop: Drawable? = null
        var drawableLeft: Drawable? = null
        var drawableRight: Drawable? = null
        attributes.sGetString(F.drawableBottom){
            drawableBottom = getDrawableContentById(it,renderer)
        }
        attributes.sGetString(F.drawableTop){
            drawableTop = getDrawableContentById(it,renderer)
        }
        attributes.sGetString(F.drawableLeft){
            drawableLeft = getDrawableContentById(it,renderer)
        }
        attributes.sGetString(F.drawableRight){
            drawableRight = getDrawableContentById(it,renderer)
        }
        view.setCompoundDrawablesWithIntrinsicBounds(
                drawableLeft,
                drawableTop,
                drawableRight,
                drawableBottom
        )
    }

    private fun getDrawableContentById(str: String, renderer: Renderer): Drawable?
    {
        return renderer.getDrawable(str)
    }
}