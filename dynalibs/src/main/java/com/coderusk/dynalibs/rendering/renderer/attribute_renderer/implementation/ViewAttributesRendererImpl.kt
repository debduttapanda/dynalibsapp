package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.view.View
import com.coderusk.dynalibs.*
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.ViewAttributesRenderer
import org.json.JSONArray
import org.json.JSONObject

object ViewAttributesRendererImpl: ViewAttributesRenderer {
    override fun render(view: View, attributes: JSONObject, renderer: Renderer)
    {
        attributes.FPR(F.alpha){
            view.alpha = it as Float
        }
        attributes.SPR(F.autofillHints){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.setAutofillHints(*renderer.factory.autoFillHintParser.parse(it as String).toTypedArray())
            }
        }
        attributes.SPR(F.background){
            renderer.factory.viewBackgroundRenderer.render(view, it as String, renderer)
        }
        attributes.APR(F.backgroundTint){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                view.backgroundTintList = renderer.factory.colorStateListParser.parse(it as JSONArray)
            }
        }
        attributes.SPR(F.backgroundTintMode){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                view.backgroundTintMode = renderer.factory.tintModeParser.parse(it as String)
            }
        }
        attributes.BPR(F.clickable){
            view.isClickable = it as Boolean
        }
        attributes.BPR(F.clipToOutline){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                view.clipToOutline = it as Boolean
            }
        }
        attributes.SPR(F.contentDescription){
            view.contentDescription = it as String
        }
        attributes.BPR(F.contextClickable){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                view.isContextClickable = it as Boolean
            }
        }
        attributes.BPR(F.defaultFocusHighlightEnabled){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.defaultFocusHighlightEnabled = it as Boolean
            }
        }
        attributes.BPR(F.isDuplicateParentStateEnabled){
            view.isDuplicateParentStateEnabled = it as Boolean
        }
        attributes.SPR(F.elevation){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                view.elevation = renderer.factory.dimensionParser.parse(it as String,renderer).toFloat()
            }
        }
        attributes.BPR(F.isScrollbarFadingEnabled){
            view.isScrollbarFadingEnabled = it as Boolean
        }
        attributes.BPR(F.isHorizontalFadingEdgeEnabled){
            view.isHorizontalFadingEdgeEnabled = it as Boolean
        }
        attributes.BPR(F.isVerticalFadingEdgeEnabled){
            view.isVerticalFadingEdgeEnabled = it as Boolean
        }
        attributes.BPR(F.fadingEdgeLength){
            view.setFadingEdgeLength(renderer.factory.dimensionParser.parse(it as String,renderer))
        }
        attributes.BPR(F.filterTouchesWhenObscured){
            view.filterTouchesWhenObscured = it as Boolean
        }
        attributes.BPR(F.fitsSystemWindows){
            view.fitsSystemWindows = it as Boolean
        }
        attributes.SPR(F.focusable){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.focusable = renderer.factory.focusableParser.parse(it as String, renderer)
            }
        }
        attributes.BPR(F.focusableInTouchMode){
            view.isFocusableInTouchMode = it as Boolean
        }
        attributes.BPR(F.isFocusedByDefault){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.isFocusedByDefault = it as Boolean
            }
        }
        attributes.BPR(F.forceHasOverlappingRendering){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                view.forceHasOverlappingRendering(it as Boolean)
            }
        }
        attributes.SPR(F.foreground){
            renderer.factory.viewForegroundRenderer.render(view, it as String, renderer)
        }
        attributes.SPR(F.foregroundGravity){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                view.foregroundGravity = renderer.factory.gravityParser.parse(it as String)
            }
        }
        attributes.SPR(F.foregroundTintMode){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                view.foregroundTintMode = renderer.factory.tintModeParser.parse(it as String)
            }
        }
        attributes.BPR(F.isHapticFeedbackEnabled){
            view.isHapticFeedbackEnabled = it as Boolean
        }
        attributes.SPR(F.importantForAccessibility){
            view.importantForAccessibility = renderer.factory.importantForAccessibilityParser.parser(it as String)
        }
        attributes.SPR(F.importantForAutofill){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.importantForAutofill = renderer.factory.importantForAutoFillParser.parse(it as String)
            }
        }
        attributes.SPR(F.importantForContentCapture){
            view.importantForContentCapture = renderer.factory.importantForContentCaptureParser.parse(it as String)
        }
        attributes.BPR(F.isScrollContainer){
            view.isScrollContainer = it as Boolean
        }
        attributes.BPR(F.keepScreenOn){
            view.keepScreenOn = it as Boolean
        }
        attributes.BPR(F.isKeyboardNavigationCluster){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.isKeyboardNavigationCluster = it as Boolean
            }
        }
        attributes.SPR(F.layerType){
            renderer.factory.layerTypeRenderer.render(view, it as String,renderer)
        }
        attributes.SPR(F.layoutDirection){
            view.layoutDirection = renderer.factory.layoutDirectionParser.parse(it as String)
        }
        attributes.SPR(F.isLongClickable){
            view.isLongClickable = it as Boolean
        }
        attributes.SPR(F.minHeight){
            view.minimumHeight = renderer.factory.dimensionParser.parse(it as String, renderer)
        }
        attributes.SPR(F.minWidth){
            view.minimumWidth = renderer.factory.dimensionParser.parse(it as String, renderer)
        }
        attributes.SPR(F.nextClusterForwardId){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.nextClusterForwardId = renderer.getId(it as String)
            }
        }
        attributes.SPR(F.nextFocusDown){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.nextFocusDownId = renderer.getId(it as String)
            }
        }
        attributes.SPR(F.nextFocusForward){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.nextFocusForwardId = renderer.getId(it as String)
            }
        }
        attributes.SPR(F.nextFocusLeft){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.nextFocusLeftId = renderer.getId(it as String)
            }
        }
        attributes.SPR(F.nextFocusRight){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.nextFocusRightId = renderer.getId(it as String)
            }
        }
        attributes.SPR(F.nextFocusUp){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.nextFocusUpId = renderer.getId(it as String)
            }
        }
        attributes.SPR(F.outlineAmbientShadowColor){
            view.outlineAmbientShadowColor = (it as String).toColor()
        }
        attributes.SPR(F.outlineSpotShadowColor){
            view.outlineSpotShadowColor = (it as String).toColor()
        }
        renderer.factory.paddingRenderer.render(view, attributes, renderer)
        attributes.FPR(F.rotation){
            view.rotation = it as Float
        }
        attributes.FPR(F.rotationX){
            view.rotationX = it as Float
        }
        attributes.FPR(F.rotationY){
            view.rotationY = it as Float
        }
        attributes.BPR(F.saveEnabled){
            view.isSaveEnabled = it as Boolean
        }
        attributes.BPR(F.scaleX){
            view.scaleX = it as Float
        }
        attributes.BPR(F.scaleY){
            view.scaleY = it as Float
        }
        attributes.BPR(F.screenReaderFocusable){
            view.isScreenReaderFocusable = it as Boolean
        }
        renderer.factory.scrollIndicatorsRenderer.render(view, attributes)
        attributes.SPR(F.scrollX){
            view.scrollX = renderer.factory.dimensionParser.parse(it as String, renderer)
        }
        attributes.SPR(F.scrollY){
            view.scrollY = renderer.factory.dimensionParser.parse(it as String, renderer)
        }
        attributes.IPR(F.scrollbarDefaultDelayBeforeFade){
            view.scrollBarDefaultDelayBeforeFade = it as Int
        }
        attributes.IPR(F.scrollbarFadeDuration){
            view.scrollBarFadeDuration = it as Int
        }
        attributes.SPR(F.scrollbarStyle){
            view.scrollBarStyle = renderer.factory.scrollbarStyleParser.parse(it as String)
        }
        attributes.SPR(F.scrollbarSize){
            view.scrollBarSize = renderer.factory.dimensionParser.parse(it as String, renderer)
        }
        attributes.SPR(F.horizontalScrollbarThumbDrawable){
            var value = it as String
            if(value.startsWith("$")){
                value = value.replace("$","")
            }
            view.horizontalScrollbarThumbDrawable = renderer.getDrawable(value)
        }
        attributes.SPR(F.verticalScrollbarThumbDrawable){
            var value = it as String
            if(value.startsWith("$")){
                value = value.replace("$","")
            }
            view.verticalScrollbarThumbDrawable = renderer.getDrawable(value)
        }
        attributes.SPR(F.verticalScrollbarTrackDrawable){
            var value = it as String
            if(value.startsWith("$")){
                value = value.replace("$","")
            }
            view.verticalScrollbarTrackDrawable = renderer.getDrawable(value)
        }
        attributes.SPR(F.horizontalScrollbarTrackDrawable){
            var value = it as String
            if(value.startsWith("$")){
                value = value.replace("$","")
            }
            view.horizontalScrollbarTrackDrawable = renderer.getDrawable(value)
        }
        attributes.BPR(F.isHorizontalScrollBarEnabled){
            view.isHorizontalScrollBarEnabled = it as Boolean
        }
        attributes.BPR(F.isVerticalScrollBarEnabled){
            view.isVerticalScrollBarEnabled = it as Boolean
        }
        attributes.BPR(F.soundEffectEnabled){
            view.isSoundEffectsEnabled = it as Boolean
        }
        attributes.SPR(F.tag){
            view.tag = it as String
        }
        attributes.SPR(F.textAlignment){
            view.textAlignment = renderer.factory.textAlignmentParser.parse(it as String)
        }
        attributes.SPR(F.textDirection){
            view.textDirection = renderer.factory.textDirectionParser.parse(it as String)
        }
        attributes.SPR(F.toolTipText){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.tooltipText = it as String
            }
        }
        attributes.SPR(F.pivotX){
            view.pivotX = renderer.factory.dimensionParser.parse(it as String,renderer).toFloat()
        }
        attributes.SPR(F.pivotY){
            view.pivotY = renderer.factory.dimensionParser.parse(it as String,renderer).toFloat()
        }
        attributes.SPR(F.transitionName){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                view.transitionName = it as String
            }
        }
        attributes.SPR(F.translationX){
            view.translationX = renderer.factory.dimensionParser.parse(it as String,renderer).toFloat()
        }
        attributes.SPR(F.translationY){
            view.translationY = renderer.factory.dimensionParser.parse(it as String, renderer).toFloat()
        }
        attributes.SPR(F.translationZ){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                view.translationZ = renderer.factory.dimensionParser.parse(it as String, renderer).toFloat()
            }
        }
        attributes.SPR(F.visibility){
            view.visibility = renderer.factory.visibilityParser.parse(it as String)
        }
    }

    private fun composeAutoFillHints(s: String): ArrayList<String> {
        var autoFills = ArrayList<String>()
        if(s.isNotEmpty())
        {
            if(!s.contains(","))
            {
                autoFills.add(singleAutoFillHint(s))
            }
            else
            {
                var parts = s.split(",")
                var count = parts.size
                for(i in 0 until count)
                {
                    var part = parts[i]
                    var autoFill = singleAutoFillHint(part)
                    if(autoFill.isNotEmpty())
                    {
                        autoFills.add(autoFill)
                    }
                }
            }
        }
        return autoFills
    }

    private fun singleAutoFillHint(s: String): String {
        return when(s.toUpperCase())
        {
            "USERNAME"->View.AUTOFILL_HINT_USERNAME
            "EMAIL"->View.AUTOFILL_HINT_EMAIL_ADDRESS
            "NAME"->View.AUTOFILL_HINT_NAME
            "PHONE"->View.AUTOFILL_HINT_PHONE
            "POSTAL_ADDRESS"->View.AUTOFILL_HINT_POSTAL_ADDRESS
            "POSTAL_CODE"->View.AUTOFILL_HINT_POSTAL_CODE
            "CREDIT_CARD_NUMBER"->View.AUTOFILL_HINT_CREDIT_CARD_NUMBER
            "CREDIT_CARD_SECURITY_CODE"->View.AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE
            "CREDIT_CARD_EXPIRATION_DATE"->View.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE
            "CREDIT_CARD_EXPIRATION_DAY"->View.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY
            "CREDIT_CARD_EXPIRATION_MONTH"->View.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH
            "CREDIT_CARD_EXPIRATION_YEAR"->View.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR
            else->""
        }
    }
}