package com.coderusk.dynalibs.rendering.renderer.others.interfaces

interface ViewGroupTypeValidator {
    fun validate(parentClass: Class<*>): Boolean
}