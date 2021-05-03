package com.coderusk.dynalibs.rendering.parser.implementation

import android.text.util.Linkify
import com.coderusk.dynalibs.rendering.parser.interfaces.AutoLinkMaskParser
import com.coderusk.dynalibs.rendering.renderer.Renderer

object AutoLinkMaskParserImpl: AutoLinkMaskParser {
    override fun parse(input: String, renderer: Renderer): Int {
        return when(input){
            "web" -> {
                Linkify.WEB_URLS
            }
            "email" -> {
                Linkify.EMAIL_ADDRESSES
            }
            "phone" -> {
                Linkify.PHONE_NUMBERS
            }
            else->{
                0
            }
        }
    }
}