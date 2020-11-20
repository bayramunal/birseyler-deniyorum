package com.hacib.duygusalbiruygulama.network

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await


class Firebase {
    private val mAuth = FirebaseAuth.getInstance()
    private lateinit var firebaseUser: FirebaseUser
    lateinit var result: String

    suspend fun login(email: String, password: String) : AuthResult
            = mAuth.signInWithEmailAndPassword(email, password).await()

}