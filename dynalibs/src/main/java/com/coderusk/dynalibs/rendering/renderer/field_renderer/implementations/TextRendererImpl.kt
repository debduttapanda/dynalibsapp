package com.coderusk.dynalibs.rendering.renderer.field_renderer.implementations

import android.graphics.drawable.Drawable
import android.text.Html
import android.text.style.DynamicDrawableSpan
import android.widget.TextView
import com.coderusk.dynalibs.*
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces.TextRenderer
import lt.neworld.spanner.Span
import lt.neworld.spanner.Spanner
import lt.neworld.spanner.Spans
import org.json.JSONArray
import org.json.JSONObject

object TextRendererImpl: TextRenderer {
    override fun render(view: TextView, attributes: JSONObject, renderer: Renderer) {
        attributes.sGetJsonObject(F.textContent){
            renderText(view, it, renderer)
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

    private fun getVerticalAlignment(sVerticalAlignment: String): Int {
        return when(sVerticalAlignment){
            "ALIGN_BOTTOM" -> DynamicDrawableSpan.ALIGN_BOTTOM
            "ALIGN_BASELINE" -> DynamicDrawableSpan.ALIGN_BASELINE
            else-> DynamicDrawableSpan.ALIGN_CENTER
        }
    }

    private fun getDrawableFromId(drawId: String, renderer: Renderer): Drawable? {
        if(drawId.startsWith("$"))
        {
            var did = drawId.replace("$","")
            return renderer.getDrawable(did)
        }
        return null
    }

}