package com.hacib.duygusalbiruygulama.login

import com.hacib.duygusalbiruygulama.network.Firebase

class LoginRepository(
    private val firebase: Firebase,
) {
    suspend fun loginRequest(email: String, password: String) = firebase.login(email, password)
}