package com.hacib.duygusalbiruygulama.network

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await


class Firebase {
    private val mAuth = FirebaseAuth.getInstance()

    suspend fun login(email: String, password: String) : AuthResult
            = mAuth.signInWithEmailAndPassword(email, password).await()

}