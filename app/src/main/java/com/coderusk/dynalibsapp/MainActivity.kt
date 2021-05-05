package com.coderusk.dynalibsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coderusk.dynalibs.dyna.Dyna


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Dyna(this).start()
    }
}