/*
   Copyright 2018 Paul LeBeau, Cave Rock Software Ltd.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.coderusk.dynalibs.svg;

import android.graphics.Canvas;

import com.coderusk.dynalibs.svg.utils.RenderOptionsBase;

/**
 * A fluent builder class that creates a render configuration object for the
 * {@link SVG#renderToCanvas(Canvas, com.coderusk.dynalibs.svg.RenderOptions)} and {@link SVG#renderToPicture(int,int, com.coderusk.dynalibs.svg.RenderOptions)} methods.
 *
 * <h3>Example usage</h3>
 *
 * <pre class="code-block">
 * {@code
 * RenderOption renderOptions = RenderOptions.create();
 * renderOptions.viewPort(100f, 100f, 400f, 300f)   // Set the area of the Canvas to render the SVG into
 *              .css("rect { fill: red; }")         // Add some CSS that makes all rectangles red
 * svg.renderToCanvas(canvas, renderOptions);
 * }
 * </pre>
 * @since 1.3
 */

public class RenderOptions extends RenderOptionsBase
{

   /**
    * Create a new <code>RenderOptions</code> instance.  You can choose to use either this constructor,
    * or <code>new RenderOptions.create()</code>.  Both are equivalent.
    */
   public RenderOptions()
   {
      super();
   }


   /**
    * Create a new <code>RenderOptions</code> instance.  This is just an alternative to <code>new RenderOptions()</code>.
    * @return new instance of this class.
    */
   public static com.coderusk.dynalibs.svg.RenderOptions create()
   {
      return new com.coderusk.dynalibs.svg.RenderOptions();
   }


   /**
    * Creates a copy of the given <code>RenderOptions</code> object.
    * @param other the object to copy
    */
   public RenderOptions(com.coderusk.dynalibs.svg.RenderOptions other)
   {
      super(other);
   }

   /**
    * Specifies some additional CSS rules that will be applied during render in addition to
    * any specified in the file itself.
    * @param css CSS rules to apply
    * @return this same <code>RenderOptions</code> instance
    */
   public com.coderusk.dynalibs.svg.RenderOptions css(String css)
   {
      return (com.coderusk.dynalibs.svg.RenderOptions) super.css(css);
   }


   /**
    * Returns true if this RenderOptions instance has had CSS set with {@code css()}.
    * @return true if this RenderOptions instance has had CSS set
    */
   public boolean hasCss()
   {
      return super.hasCss();
   }


   /**
    * Specifies how the renderer should handle aspect ratio when rendering the SVG.
    * If not specified, the default will be <code>PreserveAspectRatio.LETTERBOX</code>. This is
    * equivalent to the SVG default of <code>xMidYMid meet</code>.
    * @param preserveAspectRatio the new aspect ration value
    * @return this same <code>RenderOptions</code> instance
    */
   @SuppressWarnings("UnusedReturnValue")
   public com.coderusk.dynalibs.svg.RenderOptions preserveAspectRatio(com.coderusk.dynalibs.svg.PreserveAspectRatio preserveAspectRatio)
   {
      return (com.coderusk.dynalibs.svg.RenderOptions) super.preserveAspectRatio(preserveAspectRatio);
   }


   /**
    * Returns true if this RenderOptions instance has had a preserveAspectRatio value set with {@code preserveAspectRatio()}.
    * @return true if this RenderOptions instance has had a preserveAspectRatio value set
    */
   public boolean hasPreserveAspectRatio()
   {
      return super.hasPreserveAspectRatio();
   }


   /**
    * Specifies the {@code id} of a {@code <view>} element in the SVG.  A {@code <view>}
    * element is a way to specify a predetermined view of the document, that differs from the default view.
    * For example it can allow you to focus in on a small detail of the document.
    *
    * Note: setting this option will override any {@link #viewBox(float,float,float,float)} or {@link #preserveAspectRatio(com.coderusk.dynalibs.svg.PreserveAspectRatio)} settings.
    *
    * @param viewId the id attribute of the view that should be used for rendering
    * @return this same <code>RenderOptions</code> instance
    */
   public com.coderusk.dynalibs.svg.RenderOptions view(String viewId)
   {
      return (com.coderusk.dynalibs.svg.RenderOptions) super.view(viewId);
   }


   /**
    * Returns true if this RenderOptions instance has had a view set with {@code view()}.
    * @return true if this RenderOptions instance has had a view set
    */
   public boolean hasView()
   {
      return super.hasView();
   }


   /**
    * Specifies alternative values to use for the root element {@code viewBox}. Any existing {@code viewBox}
    * attribute value will be ignored.
    *
    * Note: will be overridden if a {@link #view(String)} is set.
    *
    * @param minX The left X coordinate of the viewBox
    * @param minY The top Y coordinate of the viewBox
    * @param width The width of the viewBox
    * @param height The height of the viewBox
    * @return this same <code>RenderOptions</code> instance
    */
   public com.coderusk.dynalibs.svg.RenderOptions viewBox(float minX, float minY, float width, float height)
   {
      return (com.coderusk.dynalibs.svg.RenderOptions) super.viewBox(minX, minY, width, height);
   }


   /**
    * Returns true if this RenderOptions instance has had a viewBox set with {@code viewBox()}.
    * @return true if this RenderOptions instance has had a viewBox set
    */
   public boolean hasViewBox()
   {
      return super.hasViewBox();
   }


   /**
    * Describes the viewport into which the SVG should be rendered.  If this is not specified,
    * then the whole of the canvas will be used as the viewport.  If rendering to a <code>Picture</code>
    * then a default viewport width and height will be used.

    * @param minX The left X coordinate of the viewport
    * @param minY The top Y coordinate of the viewport
    * @param width The width of the viewport
    * @param height The height of the viewport
    * @return this same <code>RenderOptions</code> instance
    */
   public com.coderusk.dynalibs.svg.RenderOptions viewPort(float minX, float minY, float width, float height)
   {
      return (com.coderusk.dynalibs.svg.RenderOptions) super.viewPort(minX, minY, width, height);
   }


   /**
    * Returns true if this RenderOptions instance has had a viewPort set with {@code viewPort()}.
    * @return true if this RenderOptions instance has had a viewPort set
    */
   public boolean hasViewPort()
   {
      return super.hasViewPort();
   }


   /**
    * Specifies the {@code id} of an element, in the SVG, to treat as the target element when
    * using the {@code :target} CSS pseudo class.
    *
    * @param targetId the id attribute of an element
    * @return this same <code>RenderOptions</code> instance
    */
   public com.coderusk.dynalibs.svg.RenderOptions target(String targetId)
   {
      return (com.coderusk.dynalibs.svg.RenderOptions) super.target(targetId);
   }


   /**
    * Returns true if this RenderOptions instance has had a target set with {@code target()}.
    * @return true if this RenderOptions instance has had a target set
    */
   public boolean hasTarget()
   {
      return super.hasTarget();
   }


}
