package com.coderusk.dynalibs.rendering.parser.implementation

import android.text.Layout
import com.coderusk.dynalibs.rendering.parser.interfaces.BreakStrategyParser

object BreakStrategyParserImpl : BreakStrategyParser {
    override fun parse(input: String): Int {
        return when(input){
            "balanced" -> {
                Layout.BREAK_STRATEGY_BALANCED
            }
            "high_quality" -> {
                Layout.BREAK_STRATEGY_HIGH_QUALITY
            }
            else->{
                Layout.BREAK_STRATEGY_SIMPLE
            }
        }
    }
}