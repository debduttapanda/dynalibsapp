package com.coderusk.dynalibs.rendering.factory

import android.app.Activity
import com.coderusk.dynalibs.rendering.creator.LayoutParamCreator
import com.coderusk.dynalibs.rendering.creator.ViewCreator
import com.coderusk.dynalibs.rendering.drawable.DrawablesRenderer
import com.coderusk.dynalibs.rendering.parser.interfaces.*
import com.coderusk.dynalibs.rendering.renderer.GlobalsRenderer
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.*
import com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces.*
import com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.interfaces.LayoutParamRenderer
import com.coderusk.dynalibs.rendering.renderer.others.implementations.ChildrenComposerImpl
import com.coderusk.dynalibs.rendering.renderer.others.interfaces.*

interface Factory {
    val globalsRenderer: GlobalsRenderer
    val imageViewRenderer: ImageViewRenderer
    val lottieAnimationViewRenderer: LottieAnimationRenderer
    val webViewRenderer: WebViewRenderer
    val inputTypeParser: InputTypeParser
    val textRenderer: TextRenderer
    val textStyleParser: TextStyleParser
    val justificationModeParser: JustificationModeParser
    val imeOptionsParser: ImeOptionsParser
    val hyphenationFrequencyParser: HyphenationFrequencyParser
    val ellipsizeParser: EllipsizeParser
    val breakStrategyParser: BreakStrategyParser
    val autoSizeTextTypeWidthDefaultsParser: AutoSizeTextTypeWithDefaultsParser
    val autoLinkMaskParser: AutoLinkMaskParser
    val movementMethodParser: MovementMethodParser
    val textViewAttributesRenderer: TextViewAttributesRenderer
    val dimensionParser: DimensionParser
    val childrenAttacher: ChildrenAttacher
    val actionRenderer: ActionRenderer
    val viewForegroundRenderer: ViewForegroundRenderer
    val viewBackgroundRenderer: ViewBackgroundRenderer
    val scrollIndicatorsRenderer: ScrollIndicatorsRenderer
    val paddingRenderer: PaddingRenderer
    val layerTypeRenderer: LayerTypeRenderer
    val viewAttributesRenderer: ViewAttributesRenderer
    val scrollViewAttributesRenderer: ScrollViewAttributesRenderer
    val navigationViewAttributesRenderer: NavigationViewAttributesRenderer
    val linearLayoutAttributesRenderer: LinearLayoutAttributesRenderer
    val frameLayoutAttributesRenderer: FrameLayoutAttributesRenderer
    val constraintLayoutAttributesRenderer: ConstraintLayoutAttributesRenderer
    val cardViewAttributesRenderer: CardViewAttributesRenderer
    val attributeRenderer: AttributeRenderer
    val visibilityParser: VisibilityParser
    val tintModeParser: TintModeParser
    val textDirectionParser: TextDirectionParser
    val textAlignmentParser: TextAlignmentParser
    val scrollbarStyleParser: ScrollbarStyleParser
    val paintParser: PaintParser
    val orientationParser: OrientationParser
    val layoutDirectionParser: LayoutDirectionParser
    val layerTypeParser: LayerTypeParser
    val importantForContentCaptureParser: ImportantForContentCaptureParser
    val importantForAutoFillParser: ImportantForAutoFillParser
    val importantForAccessibilityParser: ImportantForAccessibilityParser
    val gravityParser: GravityParser
    val focusableParser: FocusableParser
    val colorStateListParser: ColorStateListParser
    val autoFillHintParser: AutoFillHintParser

    fun getIdManager(): IdManager
    fun getDrawableRenderer(context: Activity, renderer: Renderer): DrawablesRenderer
    fun getChildrenComposer(renderer: Renderer): ChildrenComposer
    fun getParentValidator(): ViewGroupTypeValidator
    fun getLayoutParamCreator(): LayoutParamCreator
    fun getLayoutParamRenderer(): LayoutParamRenderer
    fun getViewCreator(): ViewCreator
    fun getChildrenComposerImpl(renderer: Renderer): ChildrenComposer {
        return ChildrenComposerImpl(renderer)
    }
}