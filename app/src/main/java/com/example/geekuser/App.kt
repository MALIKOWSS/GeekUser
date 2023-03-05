package com.example.geekuser

import android.app.Application
import android.content.Context
import com.example.geekuser.utils.PreferenceHelper

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
        PreferenceHelper.unit(this)
    }

    companion object {
        private var context: Context? = null
    }
}