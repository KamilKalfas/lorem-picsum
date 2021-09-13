package com.kkalfas.lorempicsum.core

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

internal class DataBindingProvider {

    fun inflate(
        inflater: LayoutInflater,
        layoutId: Int,
        parent: ViewGroup,
        attachToParent: Boolean
    ): ViewDataBinding {
        return DataBindingUtil.inflate(inflater, layoutId, parent, attachToParent)
    }
}
