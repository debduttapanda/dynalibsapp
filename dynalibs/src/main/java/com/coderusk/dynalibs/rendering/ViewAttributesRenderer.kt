package com.coderusk.dynalibs.rendering

import android.view.View
import com.coderusk.dynalibs.*
import org.json.JSONArray
import org.json.JSONObject

open class ViewAttributesRenderer {
    companion object{
        fun render(view: View, attributes: JSONObject, renderer: Renderer)
        {
            attributes.FPR(F.alpha){
                view.alpha = it as Float
            }
            attributes.SPR(F.autofillHints){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    view.setAutofillHints(*composeAutoFillHints(it as String).toTypedArray())
                }
            }
            attributes.SPR(F.background){
                ViewBackgroundRenderer.render(view,it as String,renderer)
            }
            attributes.APR(F.backgroundTint){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    view.backgroundTintList = ColorStateListRenderer.render(it as JSONArray)
                }
            }
            attributes.SPR(F.backgroundTintMode){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    view.backgroundTintMode = TintModeRenderer.render(it as String)
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
                    view.elevation = DimensionParser.parse(it as String,renderer).toFloat()
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
                view.setFadingEdgeLength(DimensionParser.parse(it as String,renderer))
            }
            attributes.BPR(F.filterTouchesWhenObscured){
                view.filterTouchesWhenObscured = it as Boolean
            }
            attributes.BPR(F.fitsSystemWindows){
                view.fitsSystemWindows = it as Boolean
            }
            attributes.SPR(F.focusable){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    view.focusable = FocusableRenderer.render(it as String,renderer)
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
                ViewForegroundRenderer.render(view,it as String,renderer)
            }
            attributes.SPR(F.foregroundGravity){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    view.foregroundGravity = GravityRenderer.render(it as String)
                }
            }
            attributes.SPR(F.foregroundTintMode){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    view.foregroundTintMode = TintModeRenderer.render(it as String)
                }
            }
            attributes.BPR(F.isHapticFeedbackEnabled){
                view.isHapticFeedbackEnabled = it as Boolean
            }
            attributes.SPR(F.id){
                var id = renderer.getId(it as String)
                if(id!=0)
                {
                    view.id = id
                }
            }
            attributes.SPR(F.importantForAccessibility){
                view.importantForAccessibility = ImportantForAccessibilityRenderer.render(it as String)
            }
            attributes.SPR(F.importantForAutofill){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    view.importantForAutofill = ImportantForAutoFillParser.parse(it as String)
                }
            }
            attributes.SPR(F.importantForContentCapture){
                view.importantForContentCapture = ImportantForContentCaptureParser.parse(it as String)
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
                LayerTypeRenderer.render(view,it as String)
            }
            attributes.SPR(F.layoutDirection){
                view.layoutDirection = LayoutDirectionParser.parse(it as String)
            }
            attributes.SPR(F.isLongClickable){
                view.isLongClickable = it as Boolean
            }
            attributes.SPR(F.minHeight){
                view.minimumHeight = DimensionParser.parse(it as String, renderer)
            }
            attributes.SPR(F.minWidth){
                view.minimumWidth = DimensionParser.parse(it as String, renderer)
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
            attributes.SPR(F.padding){
                var num = DimensionParser.parse(it as String,renderer)
                view.setPadding(num,num,num,num)
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
}