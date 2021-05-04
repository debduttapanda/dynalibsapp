package com.coderusk.dynalibs.rendering.renderer.others.implementations

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.coderusk.dynalibs.customViews.GenericListView
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.renderer.ATTACHMENT_TYPE
import com.coderusk.dynalibs.rendering.renderer.Renderer
import com.coderusk.dynalibs.rendering.renderer.others.interfaces.ChildrenComposer
import com.coderusk.dynalibs.rendering.renderer.others.interfaces.GlvChildrenAttacher
import com.coderusk.dynalibs.sGetBoolean
import com.coderusk.dynalibs.sGetInt
import com.coderusk.dynalibs.sGetString
import org.json.JSONObject

object GlvChildrenAttacherImpl : GlvChildrenAttacher {
    override fun attach(parent: GenericListView,
                        cp: ChildrenComposer,
                        type: ATTACHMENT_TYPE,
                        attachOptions: JSONObject?,
                        renderer: Renderer) {
        var isGrid = false
        var isVerticalDirection = false
        var isReverseDirection = false
        var columnCount = 0
        var visibilityType = 0
        if(attachOptions!=null){
            attachOptions.sGetBoolean(F.grid){
                isGrid = it
            }
            attachOptions.sGetBoolean(F.vertical){
                isVerticalDirection = it
            }
            attachOptions.sGetBoolean(F.reverse){
                isReverseDirection = it
            }
            attachOptions.sGetInt(F.column){
                columnCount = it
            }
            attachOptions.sGetString(F.column){
                visibilityType = renderer.factory.visibilityParser.parse(it)
            }
        }
        parent.setup(object: GenericListView.EventCallback{
            override fun onView(position: Int, view: View?) {

            }

            override fun getItemCount(): Int {
                return cp.count()
            }

            override fun getViewId(position: Int): Int {
                return 0
            }

            override fun getLayoutId(position: Int): Int {
                return 0
            }

            override fun layoutGrid(): Boolean {
                return isGrid
            }

            override fun gridColumnCount(): Int {
                return columnCount
            }

            override fun getItemView(position: Int): View {
                var childView = cp.get(position)
                if(childView!=null)
                {
                    return childView
                }
                return View(renderer.getContext())
            }

            override fun fromLayout(): Boolean {
                return false
            }

            override fun isVertical(): Boolean {
                return isVerticalDirection
            }

            override fun isReverse(): Boolean {
                return isReverseDirection
            }

            override fun getVisibility(): Int {
                return visibilityType
            }

            override fun onViewRecycled(holder: GenericListView.MenuListAdapter.MyViewHolder?) {
                Log.d("glv_debug","onViewRecycled")
            }

            override fun onFailedToRecycleView(holder: GenericListView.MenuListAdapter.MyViewHolder?) {
                Log.d("glv_debug","onFailedToRecycleView")
            }

            override fun onViewAttachedToWindow(holder: GenericListView.MenuListAdapter.MyViewHolder?) {
                Log.d("glv_debug","onViewAttachedToWindow")
            }

            override fun onViewDetachedFromWindow(holder: GenericListView.MenuListAdapter.MyViewHolder?) {
                Log.d("glv_debug","onViewDetachedFromWindow")
            }

            override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
                Log.d("glv_debug","onAttachedToRecyclerView")
            }

            override fun onDetachedFromRecyclerView(recyclerView: RecyclerView?) {
                Log.d("glv_debug","onDetachedFromRecyclerView")
            }

        })
    }
}