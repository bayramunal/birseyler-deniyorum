package com.hacib.duygusalbiruygulama.login

import android.view.View
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var userName : String ?= null
    var password : String ?= null

    fun loginBtnClick(view: View) {
        println("username - password : $userName - $password")
    }
}