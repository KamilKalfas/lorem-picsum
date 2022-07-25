package com.kkalfas.lorempicsum.app

import android.app.Application
import com.kkalfas.lorempicsum.BuildConfig
import com.kkalfas.lorempicsum.app.util.TimberAdapter
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) TimberAdapter
    }
}
