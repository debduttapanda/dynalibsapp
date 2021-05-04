package com.coderusk.dynalibs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import android.util.StateSet

class MyStateListDrawableBuilder {

    private var pressed: Drawable? = null
    private var disabled: Drawable? = null
    private var selected: Drawable? = null
    private var checked: Drawable? = null
    private var normal: Drawable = ColorDrawable(Color.TRANSPARENT)

    fun pressed(pressed: Drawable?) = apply { this.pressed = pressed }
    fun disabled(disabled: Drawable?) = apply { this.disabled = disabled }
    fun selected(selected: Drawable?) = apply { this.selected = selected }
    fun checked(checked: Drawable?) = apply { this.checked = checked }
    fun normal(normal: Drawable) = apply { this.normal = normal }

    fun build(): StateListDrawable {
        val stateListDrawable = StateListDrawable()
        setupStateListDrawable(stateListDrawable)
        return stateListDrawable
    }

    private fun setupStateListDrawable(stateListDrawable: StateListDrawable) {
        pressed?.let {
            stateListDrawable.addState(intArrayOf(android.R.attr.state_pressed), it)
        }
        disabled?.let {
            stateListDrawable.addState(intArrayOf(-android.R.attr.state_enabled), it)
        }
        selected?.let {
            stateListDrawable.addState(intArrayOf(android.R.attr.state_selected), it)
        }
        checked?.let {
            stateListDrawable.addState(intArrayOf(android.R.attr.state_checked), it)
        }
        stateListDrawable.addState(StateSet.WILD_CARD, normal)
    }
}