package com.example.guess2win

import android.app.Application
import com.example.guess2win.utils.SharedPref

class GuessToWin : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPref.init(this)
    }
}