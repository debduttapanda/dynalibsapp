package com.coderusk.dynalibs.rendering.parser.implementation

import android.content.res.ColorStateList
import com.coderusk.dynalibs.rendering.F
import com.coderusk.dynalibs.rendering.parser.interfaces.ColorStateListParser
import com.coderusk.dynalibs.toColor
import org.json.JSONArray
import org.json.JSONObject

object ColorStateListParserImpl: ColorStateListParser {
    internal class StateItem(cs: IntArray, color: Int)
    {
        var cs: IntArray = cs
        var color = color
    }
    override fun parse(input: JSONArray): ColorStateList?
    {
        var statesObjects = ArrayList<StateItem>()
        var count = input.length()
        for(i in 0 until count)
        {
            try {
                var stateItem = input[i] as JSONObject
                if(stateItem.has(F.compoundState))
                {
                    var compoundState = stateItem.getString(F.compoundState)
                    var cs = composeCompoundStateValue(compoundState)
                    if(stateItem.has(F.color))
                    {
                        var sColor = stateItem.getString(F.color)
                        var color = sColor.toColor()
                        statesObjects.add(StateItem(cs,color))
                    }
                }
            } catch (e: Exception) {
            }
        }
        if(statesObjects.size>0)
        {
            var n = statesObjects.size
            var colors = IntArray(n){
                statesObjects[it].color
            }
            var css = Array<IntArray>(n){
                statesObjects[it].cs
            }
            return ColorStateList(css,colors)
        }
        return null
    }

    private fun composeCompoundStateValue(compoundState: String): IntArray {
        if(!compoundState.contains(","))
        {
            return IntArray(1){
                singleStateList(compoundState)
            }
        }
        else
        {
            var parts = compoundState.split(",")
            var n = parts.size
            return IntArray(n){
                var part = parts[it]
                singleStateList(part)
            }
        }
    }

    private fun singleStateList(singleState: String): Int {
        var negative = 1
        var ss = singleState
        if(singleState.startsWith("-"))
        {
            negative = -1
            ss = singleState.replace("-","")
        }
        when(ss)
        {
            "state_above_anchor"->return negative*android.R.attr.state_above_anchor
            "state_accelerated"->return negative*android.R.attr.state_accelerated
            "state_activated"->return negative*android.R.attr.state_activated
            "state_active"->return negative*android.R.attr.state_active
            "state_checkable"->return negative*android.R.attr.state_checkable
            "state_checked"->return negative*android.R.attr.state_checked
            "state_drag_can_accept"->return negative*android.R.attr.state_drag_can_accept
            "state_drag_hovered"->return negative*android.R.attr.state_drag_hovered
            "state_empty"->return negative*android.R.attr.state_empty
            "state_enabled"->return negative*android.R.attr.state_enabled
            "state_expanded"->return negative*android.R.attr.state_expanded
            "state_first"->return negative*android.R.attr.state_first
            "state_focused"->return negative*android.R.attr.state_focused
            "state_hovered"->return negative*android.R.attr.state_hovered
            "state_last"->return negative*android.R.attr.state_last
            "state_middle"->return negative*android.R.attr.state_middle
            "state_multiline"->return negative*android.R.attr.state_multiline
            "state_pressed"->return negative*android.R.attr.state_pressed
            "state_selected"->return negative*android.R.attr.state_selected
            "state_single"->return negative*android.R.attr.state_single
            "state_window_focused"->return negative*android.R.attr.state_window_focused
        }
        return 0
    }
}