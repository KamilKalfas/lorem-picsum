package com.kkalfas.lorempicsum.network.domain

import android.content.Context
import android.net.NetworkCapabilities
import com.kkalfas.lorempicsum.core.extensions.connectivityManager

class NetworkHandler constructor(
    private val context: Context
) {
    fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.connectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }
}
