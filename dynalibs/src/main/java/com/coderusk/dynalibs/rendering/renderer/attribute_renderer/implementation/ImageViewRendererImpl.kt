package com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation

import android.graphics.Matrix
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.ImageViewRenderer
import com.coderusk.dynalibs.sGetBoolean
import com.coderusk.dynalibs.sGetFloatArray
import com.coderusk.dynalibs.sGetString
import org.json.JSONObject

object ImageViewRendererImpl : ImageViewRenderer {
    override fun render(view: ImageView, attributes: JSONObject, renderer: Renderer) {
        renderer.factory.viewAttributesRenderer.render(view,attributes,renderer)
        attributes.sGetBoolean(F.adjustViewBounds)
        {
            view.adjustViewBounds = it
        }
        attributes.sGetString(F.baseline){
            view.baseline = renderer.factory.dimensionParser.parse(it,renderer)
        }
        attributes.sGetBoolean(F.baselineAlignBottom){
            view.baselineAlignBottom = it
        }
        attributes.sGetBoolean(F.cropToPadding){
            view.cropToPadding = it
        }
        attributes.sGetString(F.maxWidth){
            view.maxWidth = renderer.factory.dimensionParser.parse(it,renderer)
        }
        attributes.sGetString(F.maxHeight){
            view.maxHeight = renderer.factory.dimensionParser.parse(it,renderer)
        }
        attributes.sGetString(F.imageScaleType){
            view.scaleType = when(it){
                "center" -> ImageView.ScaleType.CENTER
                "center_crop" -> ImageView.ScaleType.CENTER_CROP
                "center_inside" -> ImageView.ScaleType.CENTER_INSIDE
                "fit_center" -> ImageView.ScaleType.FIT_CENTER
                "fit_end" -> ImageView.ScaleType.FIT_END
                "fit_start" -> ImageView.ScaleType.FIT_START
                "fit_xy" -> ImageView.ScaleType.FIT_XY
                "matrix" -> ImageView.ScaleType.MATRIX
                else->ImageView.ScaleType.FIT_CENTER
            }
        }
        attributes.sGetFloatArray(F.matrix){
            var m = Matrix()
            m.setValues(it)
            view.imageMatrix = m
        }
        attributes.sGetString(F.srcDrawable){
            view.setImageDrawable(renderer.getDrawable(it))
        }
        attributes.sGetString(F.srcUrl){
            var glide = Glide
                .with(renderer.getContext())
                .load(it)

            attributes.sGetString(F.imageScaleType){scaleType->
                when(scaleType){
                    "center" -> glide.fitCenter()
                    "center_crop" -> glide.centerCrop()
                    "center_inside" -> glide.centerInside()
                    "fit_center" -> glide.fitCenter()
                }
            }

            glide.into(view)
        }
        attributes.sGetString(F.colorFilter){
            view.setColorFilter(renderer.factory.colorParser.parse(it,renderer))
        }
    }
}