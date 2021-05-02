package com.coderusk.dynalibs.rendering.drawable

import android.app.Activity
import android.graphics.BlendMode
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import androidx.core.graphics.PathParser
import com.coderusk.dynalibs.*
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.GravityRenderer
import com.coderusk.dynalibs.rendering.Renderer
import org.json.JSONArray
import org.json.JSONObject
import top.defaults.drawabletoolbox.*

class DrawablesRenderer(var context: Activity,var renderer: Renderer) {
    private var drawablesContent: JSONArray? = null
    fun load(drawables: JSONArray) {
        this.drawablesContent = drawables
    }

    fun getById(did: String): Drawable? {
        var content = getDrawableContentById(did)
        content?.let { cnt ->
            return drawableFromContent(cnt,"")
        }
        return null
    }

    private fun getDrawableContentById(did: String): JSONObject? {
        if(drawablesContent==null)
        {
            return null
        }
        try {
            var count = drawablesContent?.length()
            if(count!!>0)
            {
                for(i in 0 until count!!)
                {
                    var drawableContent = drawablesContent!![i] as JSONObject
                    if(drawableContent.has(F.did))
                    {
                        var cdid = drawableContent.getString(F.did)
                        if(cdid==did)
                        {
                            return drawableContent
                        }
                    }
                }
            }
        } catch (e: Exception) {
        }
        return null
    }

    private fun drawableFromContent(content: JSONObject, tint: String): Drawable? {
        content?.let {
            if(content.has(F.type))
            {
                var type = content.getString(F.type)
                var drawable = when(type)
                {
                    "drawable" -> {
                        renderDrawable(content,tint)
                    }
                    "layerDrawable" -> {
                        renderLayersDrawable(content, tint)
                    }
                    "pathDrawable" -> {
                        renderPathDrawable(content, tint)
                    }
                    "stateListDrawable" -> {
                        renderStateListDrawable(content, tint)
                    }
                    else->{
                        null
                    }
                }
                if(tint.isNotEmpty())
                {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        drawable?.setTint(tint.toColor())
                    }
                }
                return drawable
            }
        }
        return null
    }

    private fun renderStateListDrawable(content: JSONObject, tint: String): Drawable? {
        var builder = StateListDrawableBuilder()

        try {
            content.sGetJsonArray(F.states){ states->
                var count = states.length()
                if(count>0)
                {
                    for(i in 0 until count)
                    {
                        var state = states[i] as JSONObject
                        state.sGetString(F.state){ st->
                            var itemId = ""
                            state.sGetString(F.item){ item->
                                itemId = item
                            }
                            if(itemId.isNotEmpty())
                            {
                                var cnt = getDrawableContentById(itemId)
                                cnt?.let {
                                    var drawable = drawableFromContent(it, tint)
                                    drawable?.let { dr->
                                        when(st)
                                        {
                                            "normal" -> {
                                                builder.normal(dr)
                                            }
                                            "pressed" -> {
                                                builder.pressed(dr)
                                            }
                                            "disabled" -> {
                                                builder.disabled(dr)
                                            }
                                            "selected" -> {
                                                builder.selected(dr)
                                            }
                                            else -> {}
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
        }

        return builder.build()
    }

    private fun renderPathDrawable(content: JSONObject, tint: String): Drawable? {
        var builder = PathShapeDrawableBuilder()

        content.sGetJsonObject(F.path){ path->
            var sw = 0.0f
            var sh = 0.0f
            path.sGetFloat(F.pathStandardWidth){
                sw = it
            }
            path.sGetFloat(F.pathStandardHeight){
                sh = it
            }
            path.sGetString(F.pathData){ pathData->
                builder.path(PathParser.createPathFromPathData(pathData), sw, sh)
            }
            path.sGetInt(F.size){
                builder.size(it)
            }
        }

        var d = builder.build {
            var paint = it.paint
            content.sGetJsonObject(F.path) { path ->
                path.sGetJsonObject(F.paintOptions){ options->
                    options.sGetString(F.color){ color->
                        paint.color = color.toColor()
                    }
                    options.sGetString(F.style){ style->
                        when(style.toLowerCase())
                        {
                            "fill" -> {
                                paint.style = Paint.Style.FILL
                            }
                            "stroke" -> {
                                paint.style = Paint.Style.STROKE
                            }
                            "fill_and_stroke" -> {
                                paint.style = Paint.Style.FILL_AND_STROKE
                            }
                        }
                    }
                    options.sGetString(F.blendMode){ blendMode->
                        when(blendMode)
                        {
                            "CLEAR" -> {
                                paint.blendMode = BlendMode.CLEAR
                            }
                            "COLOR" -> {
                                paint.blendMode = BlendMode.COLOR
                            }
                            "COLOR_BURN" -> {
                                paint.blendMode = BlendMode.COLOR_BURN
                            }
                            "COLOR_DODGE" -> {
                                paint.blendMode = BlendMode.COLOR_DODGE
                            }
                            "DARKEN" -> {
                                paint.blendMode = BlendMode.DARKEN
                            }
                            "DIFFERENCE" -> {
                                paint.blendMode = BlendMode.DIFFERENCE
                            }
                            "DST" -> {
                                paint.blendMode = BlendMode.DST
                            }
                            "DST_ATOP" -> {
                                paint.blendMode = BlendMode.DST_ATOP
                            }
                            "DST_IN" -> {
                                paint.blendMode = BlendMode.DST_IN
                            }
                            "DST_OUT" -> {
                                paint.blendMode = BlendMode.DST_OUT
                            }
                            "DST_OVER" -> {
                                paint.blendMode = BlendMode.DST_OVER
                            }
                            "EXCLUSION" -> {
                                paint.blendMode = BlendMode.EXCLUSION
                            }
                            "HARD_LIGHT" -> {
                                paint.blendMode = BlendMode.HARD_LIGHT
                            }
                            "HUE" -> {
                                paint.blendMode = BlendMode.HUE
                            }
                            "LIGHTEN" -> {
                                paint.blendMode = BlendMode.LIGHTEN
                            }
                            "LUMINOSITY" -> {
                                paint.blendMode = BlendMode.LUMINOSITY
                            }
                            "MODULATE" -> {
                                paint.blendMode = BlendMode.MODULATE
                            }
                            "MULTIPLY" -> {
                                paint.blendMode = BlendMode.MULTIPLY
                            }
                            "OVERLAY" -> {
                                paint.blendMode = BlendMode.OVERLAY
                            }
                            "PLUS" -> {
                                paint.blendMode = BlendMode.PLUS
                            }
                            "SATURATION" -> {
                                paint.blendMode = BlendMode.SATURATION
                            }
                            "SCREEN" -> {
                                paint.blendMode = BlendMode.SCREEN
                            }
                            "SOFT_LIGHT" -> {
                                paint.blendMode = BlendMode.SOFT_LIGHT
                            }
                            "SRC" -> {
                                paint.blendMode = BlendMode.SRC
                            }
                            "SRC_ATOP" -> {
                                paint.blendMode = BlendMode.SRC_ATOP
                            }
                            "SRC_IN" -> {
                                paint.blendMode = BlendMode.SRC_IN
                            }
                            "SRC_OUT" -> {
                                paint.blendMode = BlendMode.SRC_OUT
                            }
                            "SRC_OVER" -> {
                                paint.blendMode = BlendMode.SRC_OVER
                            }
                            "XOR" -> {
                                paint.blendMode = BlendMode.XOR
                            }
                        }
                    }
                    options.sGetInt(F.alpha){ alpha->
                        paint.alpha = alpha
                    }
                    options.sGetBoolean(F.antialias){ antiAlias->
                        paint.isAntiAlias = antiAlias
                    }
                    options.sGetStringArray(F.shadowLayer){ shadowLayer->
                        if(shadowLayer.size==4)
                        {
                            paint.setShadowLayer(
                                shadowLayer[0].toFloat(),
                                shadowLayer[1].toFloat(),
                                shadowLayer[2].toFloat(),
                                shadowLayer[3].toColor()
                            )
                        }
                    }
                    options.sGetString(F.strokeCap){ strokeCap->
                        when(strokeCap.toUpperCase())
                        {
                            "BUTT" -> {
                                paint.strokeCap = Paint.Cap.BUTT
                            }
                            "ROUND" -> {
                                paint.strokeCap = Paint.Cap.ROUND
                            }
                            "SQUARE" -> {
                                paint.strokeCap = Paint.Cap.SQUARE
                            }
                        }
                    }
                    options.sGetString(F.strokeJoin){ strokeJoin->
                        when(strokeJoin.toUpperCase())
                        {
                            "BEVEL" -> {
                                paint.strokeJoin = Paint.Join.BEVEL
                            }
                            "MITER" -> {
                                paint.strokeJoin = Paint.Join.MITER
                            }
                            "ROUND" -> {
                                paint.strokeJoin = Paint.Join.ROUND
                            }
                        }
                    }
                    options.sGetFloat(F.strokeMiter){ strokeMiter->
                        paint.strokeMiter = strokeMiter
                    }
                }
            }
        }
        if(tint.isNotEmpty())
        {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                d.setTint(tint.toColor())
            }
        }
        return d
    }

    private fun renderLayersDrawable(content: JSONObject, tint: String): Drawable? {
        var builder = LayerDrawableBuilder()
        setupRenderDrawableDefinitions(content, builder)
        try {
            if(content.has(F.layers))
            {
                var layers = content.getJSONArray(F.layers)
                var count = layers.length()
                if(count>0)
                {
                    for(i in 0 until count)
                    {
                        var layer = layers[i] as JSONObject
                        var drawable = getDrawableForLayer(layer, tint)
                        drawable?.let{
                            builder.add(drawable)
                            setLayerOptions(builder, layer)
                        }
                    }
                }
            }
        } catch (e: Exception) {
        }
        return builder.build()
    }

    private fun setLayerOptions(builder: LayerDrawableBuilder, layer: JSONObject) {
        layer.sGetJsonObject(F.options){ options ->
            options.sGetInt(F.width){
                builder.width(it)
            }
            options.sGetInt(F.height){
                builder.height(it)
            }
            options.sGetInt(F.insetLeft){
                builder.insetLeft(it)
            }
            options.sGetInt(F.insetTop){
                builder.insetTop(it)
            }
            options.sGetInt(F.insetRight){
                builder.insetRight(it)
            }
            options.sGetInt(F.insetBottom){
                builder.insetBottom(it)
            }
            options.sGetInt(F.insetStart){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    builder.insetStart(it)
                }
            }
            options.sGetInt(F.insetEnd){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    builder.insetEnd(it)
                }
            }
            options.sGetIntArray(F.inset){
                if(it.size==1)
                {
                    builder.inset(it[0])
                }
                if(it.size==4)
                {
                    builder.inset(it[0], it[1], it[2], it[3])
                }
            }
            options.sGetIntArray(F.insetRelative){
                if(it.size==1)
                {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        builder.insetRelative(it[0])
                    }
                }
                if(it.size==4)
                {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        builder.insetRelative(it[0], it[1], it[2], it[3])
                    }
                }
            }
            options.sGetString(F.gravity){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    builder.gravity(GravityRenderer.render(it))
                }
            }
        }
    }

    private fun getDrawableForLayer(layer: JSONObject, tint: String): Drawable? {
        if(layer.has(F.did))
        {
            var did = layer.getString(F.did)
            var drawableContent = getDrawableContentById(did)
            drawableContent?.let { cnt ->
                var drawable = drawableFromContent(cnt, tint)
                return drawable
            }
        }
        return null
    }

    private fun setupRenderDrawableDefinitions(content: JSONObject, builder: LayerDrawableBuilder) {
        content.sGetJsonObject(F.definition){ def->
            def.sGetString(F.paddingMode){ paddingMode->
                when(paddingMode)
                {
                    "nest" -> {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            builder.paddingMode(LayerDrawable.PADDING_MODE_NEST)
                        }
                    }
                    "stack" -> {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            builder.paddingMode(LayerDrawable.PADDING_MODE_STACK)
                        }
                    }
                }
            }
            def.sGetInt(F.paddingLeft){
                builder.paddingLeft(it)
            }
            def.sGetInt(F.paddingTop){
                builder.paddingTop(it)
            }
            def.sGetInt(F.paddingRight){
                builder.paddingRight(it)
            }
            def.sGetInt(F.paddingBottom){
                builder.paddingBottom(it)
            }
            def.sGetInt(F.paddingStart){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    builder.paddingStart(it)
                }
            }
            def.sGetInt(F.paddingEnd){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    builder.paddingEnd(it)
                }
            }
            def.sGetInt(F.paddingRelative){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    builder.paddingRelative(it)
                }
            }
        }
    }

    private fun renderDrawable(content: JSONObject, tint: String): Drawable? {
        var drawableBuilder: DrawableBuilder? = getDrawableBuilder(content, tint)
        drawableBuilder?.let {
            return it.build()
        }
        return null
    }

    private fun getDrawableBuilder(content: JSONObject, tint: String): DrawableBuilder? {
        var builder = DrawableBuilder()
        try {
            setBaseDrawable(builder, content, tint)
            if(content.has(F.definition))
            {
                var definition = content.getJSONObject(F.definition)
                setDrawableShape(builder, definition)

                setDrawableRadius(builder, definition)
                setDrawableTopLeftRadius(builder, definition)
                setDrawableTopRightRadius(builder, definition)
                setDrawableBottomRightRadius(builder, definition)
                setDrawableBottomLeftRadius(builder, definition)

                setSolidColor(builder, definition)
                setSolidColorPressed(builder, definition)
                setDrawableInnerRadius(builder, definition)
                setDrawableInnerRadiusRatio(builder, definition)
                setDrawableThickness(builder, definition)
                setDrawableThicknessRatio(builder, definition)
                setDrawableUseLevelForRing(builder, definition)
                setDrawableRounded(builder, definition)
                setDrawableCornerRadii(builder, definition)
                setDrawableGradient(builder, definition)
                setDrawableGradientType(builder, definition)
                setDrawableAngle(builder, definition)
                setDrawableCenterX(builder, definition)
                setDrawableCenterY(builder, definition)
                setDrawableCenter(builder, definition)
                setDrawableStartColor(builder, definition)
                setDrawableCenterColor(builder, definition)
                setDrawableEndColor(builder, definition)
                setDrawableGradientColor(builder, definition)
                setDrawableGradientRadius(builder, definition)
                setDrawableGradientRadiusType(builder, definition)
                setDrawableGradientRadiusPixel(builder, definition)
                setDrawableGradientRadiusFraction(builder, definition)
                setDrawableGradientRadiusFraction(builder, definition)
                definition.sGetBoolean(F.useLevelForGradient){
                    builder.useLevelForGradient(it)
                }
                definition.sGetInt(F.width){
                    builder.width(it)
                }
                definition.sGetInt(F.height){
                    builder.height(it)
                }
                definition.sGetIntArray(F.size){ values: IntArray ->
                    if(values.size==1)
                    {
                        builder.size(values[0])
                    }
                    else if(values.size==2)
                    {
                        builder.size(values[0], values[1])
                    }
                }
                definition.sGetString(F.solidColorPressedWhenRippleUnsupported){
                    builder.solidColorPressedWhenRippleUnsupported(it.toColor())
                }
                definition.sGetString(F.solidColorDisabled){
                    builder.solidColorDisabled(it.toColor())
                }
                definition.sGetString(F.solidColorSelected){
                    builder.solidColorSelected(it.toColor())
                }
                definition.sGetInt(F.strokeWidth){
                    builder.strokeWidth(it)
                }
                definition.sGetString(F.strokeColor){
                    builder.strokeColor(it.toColor())
                }
                definition.sGetString(F.strokeColorPressed){
                    builder.strokeColorPressed(it.toColor())
                }
                definition.sGetString(F.strokeColorDisabled){
                    builder.strokeColorDisabled(it.toColor())
                }
                definition.sGetString(F.strokeColorSelected){
                    builder.strokeColorSelected(it.toColor())
                }
                definition.sGetInt(F.dashWidth){
                    builder.dashWidth(it)
                }
                definition.sGetInt(F.dashGap){
                    builder.dashGap(it)
                }
                definition.sGetBoolean(F.hairlineBordered){
                    if(it)
                    {
                        builder.hairlineBordered()
                    }
                }
                definition.sGetBoolean(F.shortDashed){
                    if(it)
                    {
                        builder.shortDashed()
                    }
                }
                definition.sGetBoolean(F.mediumDashed){
                    if(it)
                    {
                        builder.mediumDashed()
                    }
                }
                definition.sGetBoolean(F.longDashed){
                    if(it)
                    {
                        builder.longDashed()
                    }
                }
                definition.sGetBoolean(F.dashed){
                    if(it)
                    {
                        builder.dashed()
                    }
                }
                definition.sGetBoolean(F.rotate){
                    builder.rotate(it)
                }
                definition.sGetFloat(F.pivotX){
                    builder.pivotX(it)
                }
                definition.sGetFloat(F.pivotY){
                    builder.pivotY(it)
                }
                definition.sGetFloatArray(F.pivot){
                    if(it.size==2)
                    {
                        builder.pivot(it[0], it[1])
                    }
                }
                definition.sGetFloat(F.fromDegrees){
                    builder.fromDegrees(it)
                }
                definition.sGetFloat(F.toDegrees){
                    builder.toDegrees(it)
                }
                definition.sGetFloatArray(F.degrees){
                    if(it.size==2)
                    {
                        builder.degrees(it[0], it[1])
                    }
                    if(it.size==1)
                    {
                        builder.degrees(it[0])
                    }
                }
                definition.sGetFloatArray(F.rotate){
                    if(it.size==2)
                    {
                        builder.rotate(it[0], it[1])
                    }
                    if(it.size==1)
                    {
                        builder.rotate(it[0])
                    }
                }
                definition.sGetBoolean(F.scale)
                {
                    builder.scale(it)
                }
                definition.sGetInt(F.scaleLevel)
                {
                    builder.scaleLevel(it)
                }
                definition.sGetInt(F.scaleGravity)
                {
                    builder.scaleGravity(it)
                }
                definition.sGetFloat(F.scaleWidth)
                {
                    builder.scaleWidth(it)
                }
                definition.sGetFloat(F.scaleHeight)
                {
                    builder.scaleHeight(it)
                }
                definition.sGetFloatArray(F.scale){
                    if(it.size==1)
                    {
                        builder.scale(it[0])
                    }
                    if(it.size==2)
                    {
                        builder.scale(it[0], it[1])
                    }
                }
                definition.sGetBoolean(F.flip)
                {
                    builder.flip(it)
                }
                definition.sGetString(F.flipOrientation){
                    when(it.toLowerCase())
                    {
                        "vertical" -> {
                            builder.orientation(FlipDrawable.ORIENTATION_VERTICAL)
                        }
                        "horizontal" -> {
                            builder.orientation(FlipDrawable.ORIENTATION_HORIZONTAL)
                        }
                    }
                }
                definition.sGetBoolean(F.ripple)
                {
                    builder.ripple(it)
                }
                definition.sGetString(F.rippleColor){
                    builder.rippleColor(it.toColor())
                }
                definition.sGetInt(F.rippleRadius){
                    builder.rippleRadius(it)
                }
            }
        } catch (e: Exception) {
        }
        return builder
    }

    private fun setBaseDrawable(builder: DrawableBuilder, content: JSONObject, tint: String) {
        if(content.has(F.base))
        {
            var base = content.getString(F.base)
            var baseContent = getDrawableContentById(base)
            baseContent?.let { bcnt ->
                var baseDrawable = drawableFromContent(bcnt, tint)
                baseDrawable?.let {
                    builder.baseDrawable(it)
                }
            }
        }
    }

    private fun setDrawableGradientRadiusFraction(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.gradientRadiusFraction))
        {
            var gradientRadiusFraction = definition.getDouble(F.gradientRadiusFraction)
            builder.gradientRadiusInFraction(gradientRadiusFraction.toFloat())
        }
    }

    private fun setDrawableGradientRadiusPixel(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.gradientRadiusPixel))
        {
            var gradientRadiusPixel = definition.getDouble(F.gradientRadiusPixel)
            builder.gradientRadiusInPixel(gradientRadiusPixel.toFloat())
        }
    }

    private fun setDrawableGradientRadiusType(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.gradientRadiusType))
        {
            var gradientRadiusType = definition.getString(F.gradientRadiusType)
            when(gradientRadiusType)
            {
                "pixel" -> {
                    builder.gradientRadiusType(DrawableProperties.RADIUS_TYPE_PIXELS)
                }
                "fraction" -> {
                    builder.gradientRadiusType(DrawableProperties.RADIUS_TYPE_FRACTION)
                }
            }
        }
    }

    private fun setDrawableGradientRadius(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.gradientRadius))
        {
            var gradientRadius = definition.getString(F.gradientRadius)
            if(!gradientRadius.contains(" "))
            {
                builder.gradientRadius(gradientRadius.toFloat())
            }
            else
            {
                var parts = gradientRadius.split(" ")
                if(parts.size==2)
                {
                    builder.gradientRadius(parts[0].toFloat(), parts[1].toInt())
                }
            }
        }
    }

    private fun setDrawableGradientColor(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.gradientColors))
        {
            var gradientColors = definition.getString(F.gradientColors)
            if(gradientColors.contains(" "))
            {
                var parts = gradientColors.split(" ")
                if(parts.size==3)
                {
                    builder.gradientColors(
                        parts[0].toColor(),
                        parts[1].toColor(),
                        parts[2].toColor()
                    )
                }
            }
        }
    }

    private fun setDrawableEndColor(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.endColor))
        {
            var endColor = definition.getString(F.endColor)
            builder.endColor(endColor.toColor())
        }
    }

    private fun setDrawableCenterColor(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.centerColor))
        {
            var centerColor = definition.getString(F.centerColor)
            builder.centerColor(centerColor.toColor())
        }
    }

    private fun setDrawableStartColor(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.startColor))
        {
            var startColor = definition.getString(F.startColor)
            builder.startColor(startColor.toColor())
        }
    }

    private fun setDrawableCenter(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.center))
        {
            var center = definition.getString(F.center)
            if(center.contains(" "))
            {
                var parts = center.split(" ")
                if(parts.size==2)
                {
                    builder.center(parts[0].toFloat(), parts[1].toFloat())
                }
            }
        }
    }

    private fun setDrawableCenterX(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.centerX))
        {
            var centerX = definition.getDouble(F.centerX)
            builder.centerX(centerX.toFloat())
        }
    }

    private fun setDrawableCenterY(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.centerY))
        {
            var centerY = definition.getDouble(F.centerY)
            builder.centerY(centerY.toFloat())
        }
    }

    private fun setDrawableAngle(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.angle))
        {
            var angle = definition.getInt(F.angle)
            builder.angle(angle)
        }
    }

    private fun setDrawableGradientType(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.gradientType))
        {
            var gradient = definition.getString(F.gradientType)
            when(gradient)
            {
                "linear" -> {
                    builder.linearGradient()
                }
                "radial" -> {
                    builder.radialGradient()
                }
                "sweep" -> {
                    builder.sweepGradient()
                }
            }
        }
    }

    private fun setDrawableGradient(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.gradient))
        {
            var gradient = definition.getBoolean(F.gradient)
            builder.gradient(gradient)
        }
    }

    private fun setDrawableCornerRadii(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.cornerRadii))
        {
            var cornerRadii = definition.getString(F.cornerRadii)
            if(cornerRadii.contains(" "))
            {
                var parts = cornerRadii.split(" ")
                if(parts.size==4)
                {
                    var topLeft = DimensionParser.parse(parts[0],renderer)
                    var topRight = DimensionParser.parse(parts[1],renderer)
                    var bottomRight = DimensionParser.parse(parts[2],renderer)
                    var bottomLeft = DimensionParser.parse(parts[3],renderer)

                    builder.cornerRadii(topLeft, topRight, bottomRight, bottomLeft)
                }
            }
        }
    }

    private fun setDrawableRounded(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.rounded))
        {
            builder.rounded()
        }
    }

    private fun setDrawableUseLevelForRing(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.useLevelForRing))
        {
            var useLevelForRing = definition.getBoolean(F.useLevelForRing)
            builder.useLevelForRing(useLevelForRing)
        }
    }

    private fun setDrawableThicknessRatio(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.thicknessRatio))
        {
            var thicknessRatio = definition.getDouble(F.thicknessRatio)
            builder.thicknessRatio(thicknessRatio.toFloat())
        }
    }

    private fun setDrawableThickness(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.thickness))
        {
            var thickness = definition.getInt(F.thickness)
            builder.thickness(thickness)
        }
    }

    private fun setDrawableInnerRadiusRatio(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.innerRadiusRatio))
        {
            var innerRadiusRatio = definition.getDouble(F.innerRadiusRatio)
            builder.innerRadiusRatio(innerRadiusRatio.toFloat())
        }
    }

    private fun setDrawableInnerRadius(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.innerRadius))
        {
            var innerRadius = definition.getInt(F.innerRadius)
            builder.innerRadius(innerRadius)
        }
    }

    private fun setSolidColorPressed(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.solidColorPressed))
        {
            var solidColor = definition.getString(F.solidColorPressed)
            builder.solidColorPressed(solidColor.toColor())
        }
    }

    private fun setSolidColor(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.solidColor))
        {
            var solidColor = definition.getString(F.solidColor)
            builder.solidColor(solidColor.toColor())
        }
    }

    private fun setDrawableRadius(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.cornerRadius))
        {
            var cornerRadius = definition.getString(F.cornerRadius)
            var num = DimensionParser.parse(cornerRadius,renderer)
            builder.cornerRadius(num)
        }
    }

    private fun setDrawableTopLeftRadius(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.cornerTopLeftRadius))
        {
            var cornerRadius = definition.getString(F.cornerTopLeftRadius)
            var num = DimensionParser.parse(cornerRadius,renderer)
            builder.topLeftRadius(num)
        }
    }

    private fun setDrawableTopRightRadius(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.cornerTopRightRadius))
        {
            var cornerRadius = definition.getString(F.cornerTopRightRadius)
            var num = DimensionParser.parse(cornerRadius,renderer)
            builder.topRightRadius(num)
        }
    }

    private fun setDrawableBottomRightRadius(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.cornerBottomRightRadius))
        {
            var cornerRadius = definition.getString(F.cornerBottomRightRadius)
            var num = DimensionParser.parse(cornerRadius,renderer)
            builder.bottomRightRadius(num)
        }
    }

    private fun setDrawableBottomLeftRadius(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.cornerBottomLeftRadius))
        {
            var cornerRadius = definition.getString(F.cornerBottomLeftRadius)
            var num = DimensionParser.parse(cornerRadius,renderer)
            builder.bottomLeftRadius(num)
        }
    }

    private fun setDrawableShape(builder: DrawableBuilder, definition: JSONObject) {
        if(definition.has(F.shape))
        {
            var shape = definition.getString(F.shape)
            when(shape.toLowerCase())
            {
                "rectangle" -> {
                    builder.rectangle()
                }
                "oval" -> {
                    builder.oval()
                }
                "line" -> {
                    builder.line()
                }
                "ring" -> {
                    builder.ring()
                }
            }
        }
    }
}