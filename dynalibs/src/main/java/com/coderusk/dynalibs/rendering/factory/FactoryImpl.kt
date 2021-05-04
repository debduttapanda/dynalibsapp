package com.coderusk.dynalibs.rendering.factory

import android.app.Activity
import com.coderusk.dynalibs.rendering.creator.LayoutParamCreator
import com.coderusk.dynalibs.rendering.creator.LayoutParamCreatorImpl
import com.coderusk.dynalibs.rendering.creator.ViewCreator
import com.coderusk.dynalibs.rendering.creator.ViewCreatorImpl
import com.coderusk.dynalibs.rendering.drawable.DrawablesRenderer
import com.coderusk.dynalibs.rendering.drawable.DrawablesRendererImpl
import com.coderusk.dynalibs.rendering.parser.MovementMethodParserImpl
import com.coderusk.dynalibs.rendering.parser.implementation.*
import com.coderusk.dynalibs.rendering.parser.interfaces.*
import com.coderusk.dynalibs.rendering.renderer.GlobalsRenderer
import com.coderusk.dynalibs.rendering.renderer.GlobalsRendererImpl
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.implementation.*
import com.coderusk.dynalibs.rendering.renderer.attribute_renderer.interfaces.*
import com.coderusk.dynalibs.rendering.renderer.field_renderer.implementations.*
import com.coderusk.dynalibs.rendering.renderer.field_renderer.interfaces.*
import com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.implementations.LayoutParamRendererImpl
import com.coderusk.dynalibs.rendering.renderer.layout_param_renderer.interfaces.LayoutParamRenderer
import com.coderusk.dynalibs.rendering.renderer.others.implementations.*
import com.coderusk.dynalibs.rendering.renderer.others.interfaces.*

class FactoryImpl: Factory {
    override val videoPlayerAttributesRenderer: VideoPlayerAttributesRenderer
        get() = VideoPlayerAttributesRendererImpl
    override val glvChildrenAttacher: GlvChildrenAttacher
        get() = GlvChildrenAttacherImpl
    override val horizontalScrollViewAttributesRenderer: HorizontalScrollViewAttributesRenderer
        get() = HorizontalScrollViewAttributesRendererImpl
    override val checkBoxAttributeRenderer: CheckBoxAttributesRenderer
        get() = CheckBoxAttributesRendererImpl
    override val autoImageViewPagerAttributesRenderer: AutoImageViewPagerAttributesRenderer
        get() = AutoImageViewPagerAttributesRendererImpl
    override val compoundButtonAttributesRenderer: CompoundButtonAttributesRenderer
        get() = CompoundButtonAttributesRendererImpl
    override val radioButtonAttributesRenderer: RadioButtonAttributesRenderer
        get() = RadioButtonAttributesRendererImpl
    override val svgImageViewRenderer: SVGImageViewAttributesRenderer
        get() = SVGImageViewAttributesRendererImpl
    override val colorParser: ColorParser
        get() = ColorParserImpl
    override val blurMaskFilterParser: BlurMaskFilterParser
        get() = BlurMaskFilterParserImpl
    override val globalsRenderer: GlobalsRenderer
        get() = GlobalsRendererImpl
    override val imageViewRenderer: ImageViewRenderer
        get() = ImageViewRendererImpl
    override val lottieAnimationViewRenderer: LottieAnimationRenderer
        get() = LottieAnimationRendererImpl
    override val webViewRenderer: WebViewRenderer
        get() = WebViewRendererImpl
    override val inputTypeParser: InputTypeParser
        get() = InputTypeParserImpl
    override val textRenderer: TextRenderer
        get() = TextRendererImpl
    override val textStyleParser: TextStyleParser
        get() = TextStyleParserImpl
    override val justificationModeParser: JustificationModeParser
        get() = JustificationModeParserImpl
    override val imeOptionsParser: ImeOptionsParser
        get() = ImeOptionsParserImpl
    override val hyphenationFrequencyParser: HyphenationFrequencyParser
        get() = HyphenationFrequencyParserImpl
    override val ellipsizeParser: EllipsizeParser
        get() = EllipsizeParserImpl
    override val breakStrategyParser: BreakStrategyParser
        get() = BreakStrategyParserImpl
    override val autoSizeTextTypeWidthDefaultsParser: AutoSizeTextTypeWithDefaultsParser
        get() = AutoSizeTextTypeWithDefaultsParserImpl
    override val autoLinkMaskParser: AutoLinkMaskParser
        get() = AutoLinkMaskParserImpl
    override val movementMethodParser: MovementMethodParser
        get() = MovementMethodParserImpl
    override val textViewAttributesRenderer: TextViewAttributesRenderer
        get() = TextViewAttributesRendererImpl
    override val dimensionParser: DimensionParser
        get() = DimensionParserImpl
    override val childrenAttacher: ChildrenAttacher
        get() = ChildrenAttacherImpl
    override val actionRenderer: ActionRenderer
        get() = ActionRendererImpl
    override val viewForegroundRenderer: ViewForegroundRenderer
        get() = ViewForegroundRendererImpl
    override val viewBackgroundRenderer: ViewBackgroundRenderer
        get() = ViewBackgroundRendererImpl
    override val scrollIndicatorsRenderer: ScrollIndicatorsRenderer
        get() = ScrollIndicatorsRendererImpl
    override val paddingRenderer: PaddingRenderer
        get() = PaddingRendererImpl
    override val layerTypeRenderer: LayerTypeRenderer
        get() = LayerTypeRendererImpl
    override val viewAttributesRenderer: ViewAttributesRenderer
        get() = ViewAttributesRendererImpl
    override val scrollViewAttributesRenderer: ScrollViewAttributesRenderer
        get() = ScrollViewAttributesRendererImpl
    override val navigationViewAttributesRenderer: NavigationViewAttributesRenderer
        get() = NavigationViewAttributesRendererImpl
    override val linearLayoutAttributesRenderer: LinearLayoutAttributesRenderer
        get() = LinearLayoutAttributesRendererImpl
    override val frameLayoutAttributesRenderer: FrameLayoutAttributesRenderer
        get() = FrameLayoutAttributesRendererImpl
    override val constraintLayoutAttributesRenderer: ConstraintLayoutAttributesRenderer
        get() = ConstraintLayoutAttributesRendererImpl
    override val cardViewAttributesRenderer: CardViewAttributesRenderer
        get() = CardViewAttributesRendererImpl
    override val attributeRenderer: AttributeRenderer
        get() = AttributeRendererImpl
    override val visibilityParser: VisibilityParser
        get() = VisibilityParserImpl
    override val tintModeParser: TintModeParser
        get() = TintModeParserImpl
    override val textDirectionParser: TextDirectionParser
        get() = TextDirectionParserImpl
    override val textAlignmentParser: TextAlignmentParser
        get() = TextAlignmentParserImpl
    override val scrollbarStyleParser: ScrollbarStyleParser
        get() = ScrollbarStyleParserImpl
    override val paintParser: PaintParser
        get() = PaintParserImpl
    override val orientationParser: OrientationParser
        get() = OrientationParserImpl
    override val layoutDirectionParser: LayoutDirectionParser
        get() = LayoutDirectionParserImpl
    override val layerTypeParser: LayerTypeParser
        get() = LayerTypeParserImpl
    override val importantForContentCaptureParser: ImportantForContentCaptureParser
        get() = ImportantForContentCaptureParserImpl
    override val importantForAutoFillParser: ImportantForAutoFillParser
        get() = ImportantForAutoFillParserImpl
    override val importantForAccessibilityParser: ImportantForAccessibilityParser
        get() = ImportantForAccessibilityParserImpl
    override val gravityParser: GravityParser
        get() = GravityParserImpl
    override val focusableParser: FocusableParser
        get() = FocusableParserImpl
    override val colorStateListParser: ColorStateListParser
        get() = ColorStateListParserImpl
    override val autoFillHintParser: AutoFillHintParser
        get() = AutoFillHintParserImpl

    override fun getIdManager(): IdManager {
        return IdManagerImpl()
    }

    override fun getDrawableRenderer(context: Activity, renderer: Renderer): DrawablesRenderer {
        return DrawablesRendererImpl(context,renderer)
    }

    override fun getChildrenComposer(renderer: Renderer): ChildrenComposer {
        return ChildrenComposerImpl(renderer)
    }

    override fun getParentValidator(): ViewGroupTypeValidator {
        return ViewGroupTypeValidatorImpl
    }

    override fun getLayoutParamCreator(): LayoutParamCreator {
        return LayoutParamCreatorImpl
    }

    override fun getLayoutParamRenderer(): LayoutParamRenderer {
        return LayoutParamRendererImpl
    }

    override fun getViewCreator(): ViewCreator {
        return ViewCreatorImpl
    }
}