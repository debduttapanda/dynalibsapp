package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.graphics.drawable.Drawable
import android.text.Html
import android.text.InputType
import android.text.Layout
import android.text.TextUtils
import android.text.style.DynamicDrawableSpan
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.coderusk.dynalibs.*
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.TextViewAttributesRenderer
import lt.neworld.spanner.Span
import lt.neworld.spanner.Spanner
import lt.neworld.spanner.Spans
import org.json.JSONArray
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
                        when (it) {
                            "uniform" -> {
                                TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM
                            }
                            else -> {
                                TextView.AUTO_SIZE_TEXT_TYPE_NONE
                            }
                        }
                )
            }
        }
        attributes.sGetString(F.breakStrategy){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                view.breakStrategy = when(it){
                    "balanced" -> {
                        Layout.BREAK_STRATEGY_BALANCED
                    }
                    "high_quality" -> {
                        Layout.BREAK_STRATEGY_HIGH_QUALITY
                    }
                    else->{
                        Layout.BREAK_STRATEGY_SIMPLE
                    }
                }
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
            view.ellipsize = when(it){
                "marquee" -> TextUtils.TruncateAt.MARQUEE
                "end" -> TextUtils.TruncateAt.END
                "start" -> TextUtils.TruncateAt.START
                "middle" -> TextUtils.TruncateAt.MIDDLE
                else-> TextUtils.TruncateAt.END
            }
        }
        attributes.sGetString(F.hint){
            view.hint = it
        }
        attributes.sGetString(F.hyphenationFrequency){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                view.hyphenationFrequency = when(it){
                    "none" -> Layout.HYPHENATION_FREQUENCY_NONE
                    "normal" -> Layout.HYPHENATION_FREQUENCY_NORMAL
                    "full" -> Layout.HYPHENATION_FREQUENCY_FULL
                    else-> Layout.HYPHENATION_FREQUENCY_NORMAL
                }
            }
        }
        attributes.sGetString(F.imeOptions){
            view.imeOptions = composeImeOptions(it)
        }
        attributes.sGetString(F.inputType){
            view.inputType = composeInputType(it)
        }
        attributes.sGetString(F.justificationMode){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                view.justificationMode = when(it){
                    "none" -> Layout.JUSTIFICATION_MODE_NONE
                    "inter_word" -> Layout.JUSTIFICATION_MODE_INTER_WORD
                    else-> Layout.JUSTIFICATION_MODE_NONE
                }
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
                        shadowLayer[3].toColor()
                )
            }
        }
        attributes.sGetBoolean(F.singleLine){
            view.isSingleLine = it
        }
        attributes.sGetJsonObject(F.textContent){
            renderText(view, it, renderer)
        }
        attributes.sGetBoolean(F.isAllCaps){
            view.isAllCaps = it
        }
        attributes.sGetColor(F.textColor){
            view.setTextColor(it)
        }
        attributes.sGetColor(F.highlightColor){
            view.highlightColor =it
        }
        attributes.sGetColor(F.hintColor){
            view.setHintTextColor(it)
        }
        attributes.sGetColor(F.linkColor){
            view.setLinkTextColor(it)
        }
        attributes.sGetString(F.cursorDrawable){ str->
            if(str.startsWith("$"))
            {
                var dstr = str.replace("$","")
                var d = renderer.getDrawable(dstr)
                if(d!=null)
                {
                    view.textCursorDrawable = d
                }
            }
        }
        attributes.sGetBoolean(F.textIsSelectable){
            view.setTextIsSelectable(false)
        }
        attributes.sGetFloat(F.textScaleX){
            view.textScaleX = it
        }
        attributes.sGetString(F.textSelectHandle){ str ->
            if(str.startsWith("$"))
            {
                var dstr = str.replace("$","")
                var d = renderer.getDrawable(dstr)
                if(d!=null)
                {
                    view.setTextSelectHandle(d)
                }
            }
        }
        attributes.sGetString(F.textSelectHandleLeft){ str ->
            if(str.startsWith("$"))
            {
                var dstr = str.replace("$","")
                var d = renderer.getDrawable(dstr)
                if(d!=null)
                {
                    view.setTextSelectHandleLeft(d)
                }
            }
        }
        attributes.sGetString(F.textSelectHandleRight){ str ->
            if(str.startsWith("$"))
            {
                var dstr = str.replace("$","")
                var d = renderer.getDrawable(dstr)
                if(d!=null)
                {
                    view.setTextSelectHandleRight(d)
                }
            }
        }
        attributes.sGetFloat(F.textSize){
            view.textSize = it
        }
        attributes.sGetString(F.textStyle){
            view.setTypeface(null, getTextStyle(it))
        }
        attributes.sGetString(F.width){
            view.width = renderer.factory.dimensionParser.parse(it,renderer)
        }
        attributes.sGetString(F.gravity){
            view.gravity = renderer.factory.gravityParser.parse(it)
        }
    }

    private fun getTextStyle(it: String): Int {
        return if(!it.contains("|")) {
            singleTextStyle(it)
        } else {
            var parts = it.split("|")
            var ret = 0
            for(i in 0 until parts.size) {
                var part = parts[i]
                ret = ret or singleTextStyle(part)
            }
            ret
        }
    }

    private fun singleTextStyle(it: String): Int {
        return when(it){
            "bold" -> 1
            "italic" -> 2
            else->0
        }
    }

    private fun renderText(view: TextView, it: JSONObject, renderer: Renderer) {
        it.sGetString(F.textContentType){ type->
            when(type){
                "text" -> renderTextPlain(view, it)
                "html" -> renderTextHtml(view, it)
                "span" -> renderTextSpan(view, it, renderer)
            }
        }
    }

    private fun renderTextPlain(view: TextView, it: JSONObject) {
        it.sGetString(F.text){ text->
            view.text = text
        }
    }

    private fun renderTextHtml(view: TextView, it: JSONObject) {
        it.sGetString(F.html){ text->
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                view.text = Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
            }
        }
    }

    private fun renderTextSpan(view: TextView, it: JSONObject, renderer: Renderer) {
        it.sGetJsonArray(F.items){ spans->
            for(i in 0 until it.length())
            {
                try {
                    var span = spans[i] as JSONObject
                    renderSingleSpanItem(view, span, renderer)
                } catch (e: Exception) {
                }
            }
        }
    }

    private fun renderSingleSpanItem(view: TextView, item: JSONObject, renderer: Renderer) {
        var txt = ""
        item.sGetString(F.text){ text->
            txt = text
        }
        var spn: JSONArray? = null
        item.sGetJsonArray(F.spans){ spans->
            spn = spans
        }
        var set = false
        spn?.let {
            var spansList = composeGrainedSpans(spn, renderer)
            spansList?.let{
                view.text = Spanner().append(txt, *it.toTypedArray())
                set = false
            }
        }
        if(!set)
        {
            view.text = Spanner().append(txt)
        }
    }

    private fun composeGrainedSpans(spans: JSONArray?, renderer: Renderer): ArrayList<Span>? {
        var list = ArrayList<Span>()
        spans?.let { spns->
            for(i in 0 until spns.length())
            {
                try {
                    var span = spns[i] as String
                    var oSpan = getGrainedSpan(span, renderer)
                    oSpan?.let {
                        list.add(oSpan)
                    }
                } catch (e: Exception) {
                }
            }
        }
        if(list.size==0)
        {
            return null
        }
        return list
    }
    private fun getGrainedSpan(span: String, renderer: Renderer): Span? {
        if(span.contains(":"))
        {
            var parts = span.split(":")
            var key = parts[0]
            var value = parts[1]
            return createSpan(key, value, renderer)
        }
        return null
    }

    private fun createSpan(key: String, value: String, renderer: Renderer): Span? {
        try {
            return when(key)
            {
                "sizePX" -> Spans.sizePX(value.toInt())
                "sizeDP" -> Spans.sizeDP(value.toInt())
                "sizeSP" -> Spans.sizeSP(value.toInt())
                "scaleSize" -> Spans.scaleSize(value.toFloat())
                "scaleXSize" -> Spans.scaleXSize(value.toFloat())
                "bold" -> Spans.bold()
                "italic" -> Spans.italic()
                "boldItalic" -> Spans.boldItalic()
                "font" -> Spans.font(value)
                "strikeThrough" -> Spans.strikeThrough()
                "underline" -> Spans.underline()
                "background" -> Spans.background(value.toColor())
                "foreground" -> Spans.foreground(value.toColor())
                "subscript" -> Spans.subscript()
                "superscript" -> Spans.superscript()
                "image" -> {
                    var drawId = value
                    var sVerticalAlignment = ""
                    if (value.contains(" ")) {
                        var parts = value.split(" ")
                        if (parts.size == 2) {
                            drawId = parts[0]
                            sVerticalAlignment = parts[1]
                        }
                    }
                    var verAlign = getVerticalAlignment(sVerticalAlignment)
                    var drawable = getDrawableFromId(drawId,renderer)
                    drawable?.let {
                        Spans.image(it, verAlign)
                    }
                }
                "quote" -> {
                    Spans.quote(value.toColor())
                }
                "click" -> {
                    Spans.click {

                    }
                }
                "url" -> {
                    Spans.url(value)
                }
                "center" -> {
                    Spans.center()
                }
                "alignmentOpposite" -> {
                    Spans.alignmentOpposite()
                }
                "alignmentNormal" -> {
                    Spans.alignmentNormal()
                }
                "bullet" -> {
                    Spans.bullet(value.spacePart(0).toInt(), value.spacePart(1).toColor())
                }
                "leadingMargin" -> {
                    Spans.leadingMargin(value.spacePart(0).toInt(), value.spacePart(1).toInt())
                }
                "blur" -> {
                    Spans.blur(value.spacePart(0).toFloat(), value.spacePart(1).toBlur())
                }
                "emboss" -> {
                    Spans.emboss(
                            value.spacePart(0).commaParts().toFloatArray(),
                            value.spacePart(1).toFloat(),
                            value.spacePart(2).toFloat(),
                            value.spacePart(3).toFloat()

                    )
                }
                "lineBackground" -> {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                        Spans.lineBackground(value.toColor())
                    } else {
                        null
                    }
                }
                "lineHeight" -> {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                        Spans.lineHeight(value.toInt())
                    } else {
                        null
                    }
                }
                else->null
            }
        } catch (e: Exception) {
        }
        return null
    }

    private fun getDrawableFromId(drawId: String, renderer: Renderer): Drawable? {
        if(drawId.startsWith("$"))
        {
            var did = drawId.replace("$","")
            return renderer.getDrawable(did)
        }
        return null
    }

    private fun getVerticalAlignment(sVerticalAlignment: String): Int {
        return when(sVerticalAlignment){
            "ALIGN_BOTTOM" -> DynamicDrawableSpan.ALIGN_BOTTOM
            "ALIGN_BASELINE" -> DynamicDrawableSpan.ALIGN_BASELINE
            else-> DynamicDrawableSpan.ALIGN_CENTER
        }
    }

    private fun composeInputType(it: String): Int {
        return if(!it.contains("|"))
        {
            singleInputType(it)
        }
        else
        {
            var parts = it.split("|")
            var num = 0
            for(i in parts.indices){
                var part = parts[i]
                var n = singleInputType(part)
                num = num or n
            }
            num
        }
    }

    private fun singleInputType(it: String): Int {
        return when(it){
            "TYPE_TEXT_VARIATION_EMAIL_ADDRESS" -> InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            "TYPE_CLASS_DATETIME" -> InputType.TYPE_CLASS_DATETIME
            "TYPE_CLASS_NUMBER" -> InputType.TYPE_CLASS_NUMBER
            "TYPE_CLASS_PHONE" -> InputType.TYPE_CLASS_PHONE
            "TYPE_CLASS_TEXT" -> InputType.TYPE_CLASS_TEXT
            "TYPE_NUMBER_FLAG_DECIMAL" -> InputType.TYPE_NUMBER_FLAG_DECIMAL
            "TYPE_NUMBER_FLAG_SIGNED" -> InputType.TYPE_NUMBER_FLAG_SIGNED
            "TYPE_NUMBER_VARIATION_NORMAL" -> InputType.TYPE_NUMBER_VARIATION_NORMAL
            "TYPE_TEXT_FLAG_AUTO_COMPLETE" -> InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE
            "TYPE_TEXT_FLAG_AUTO_CORRECT" -> InputType.TYPE_TEXT_FLAG_AUTO_CORRECT
            "TYPE_TEXT_FLAG_CAP_CHARACTERS" -> InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
            "TYPE_TEXT_FLAG_CAP_SENTENCES" -> InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
            "TYPE_TEXT_FLAG_CAP_WORDS" -> InputType.TYPE_TEXT_FLAG_CAP_WORDS
            "TYPE_TEXT_FLAG_IME_MULTI_LINE" -> InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE
            "TYPE_TEXT_FLAG_MULTI_LINE" -> InputType.TYPE_TEXT_FLAG_MULTI_LINE
            "TYPE_TEXT_FLAG_NO_SUGGESTIONS" -> InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
            "TYPE_TEXT_VARIATION_FILTER" -> InputType.TYPE_TEXT_VARIATION_FILTER
            "TYPE_TEXT_VARIATION_NORMAL" -> InputType.TYPE_TEXT_VARIATION_NORMAL
            "TYPE_TEXT_VARIATION_PASSWORD" -> InputType.TYPE_TEXT_VARIATION_PASSWORD
            "TYPE_TEXT_VARIATION_PHONETIC" -> InputType.TYPE_TEXT_VARIATION_PHONETIC
            "TYPE_TEXT_VARIATION_URI" -> InputType.TYPE_TEXT_VARIATION_URI
            else-> InputType.TYPE_CLASS_TEXT
        }
    }

    private fun composeImeOptions(it: String): Int {
        if(!it.contains("|"))
        {
            return singleImeOption(it)
        }
        else
        {
            var parts = it.split("|")
            var num = 0
            for(i in parts.indices)
            {
                var part = parts[i]
                var n = singleImeOption(part)
                num = num or n
            }
            return num
        }
    }

    private fun singleImeOption(it: String): Int {
        return when(it){
            "normal" -> EditorInfo.IME_NULL
            "actionUnspecified" -> EditorInfo.IME_ACTION_UNSPECIFIED
            "actionNone" -> EditorInfo.IME_ACTION_NONE
            "actionGo" -> EditorInfo.IME_ACTION_GO
            "actionSearch" -> EditorInfo.IME_ACTION_SEARCH
            "actionSend" -> EditorInfo.IME_ACTION_SEND
            "actionNext" -> EditorInfo.IME_ACTION_NEXT
            "actionDone" -> EditorInfo.IME_ACTION_DONE
            "actionPrevious" -> EditorInfo.IME_ACTION_PREVIOUS
            "flagForceAscii" -> EditorInfo.IME_FLAG_FORCE_ASCII
            "flagNavigateNext" -> EditorInfo.IME_FLAG_NAVIGATE_NEXT
            "flagNavigatePrevious" -> EditorInfo.IME_FLAG_NAVIGATE_PREVIOUS
            "flagNoAccessoryAction" -> EditorInfo.IME_FLAG_NO_ACCESSORY_ACTION
            "flagNoEnterAction" -> EditorInfo.IME_FLAG_NO_ENTER_ACTION
            "flagNoExtractUi" -> EditorInfo.IME_FLAG_NO_EXTRACT_UI
            "flagNoFullscreen" -> EditorInfo.IME_FLAG_NO_FULLSCREEN
            "flagNoPersonalizedLearning" -> EditorInfo.IME_FLAG_NO_PERSONALIZED_LEARNING
            else-> EditorInfo.IME_NULL
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
        if(str.startsWith("$"))
        {
            var dstr = str.replace("$","")
            var d = renderer.getDrawable(dstr)
            return d
        }
        return null
    }
}