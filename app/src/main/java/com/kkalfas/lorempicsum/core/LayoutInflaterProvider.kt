package com.kkalfas.lorempicsum.core

import android.content.Context
import android.view.LayoutInflater

internal class LayoutInflaterProvider {

    fun get(context: Context): LayoutInflater {
        return LayoutInflater.from(context)
    }
}
