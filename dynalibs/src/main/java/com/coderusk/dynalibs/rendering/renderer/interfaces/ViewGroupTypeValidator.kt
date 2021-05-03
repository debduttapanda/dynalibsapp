package com.coderusk.dynalibs.rendering.renderer.interfaces

interface ViewGroupTypeValidator {
    fun validate(parentClass: Class<*>): Boolean
}