package com.hacib.duygusalbiruygulama.network

interface NetworkListener {

    fun onStart(message: String)
    fun onSuccess(message: String)
    fun onError(message: String)
    fun onFinished(message: String)
}