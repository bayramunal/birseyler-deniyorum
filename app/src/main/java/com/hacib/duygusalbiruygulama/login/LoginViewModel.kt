package com.hacib.duygusalbiruygulama.login

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.hacib.duygusalbiruygulama.network.Constants
import com.hacib.duygusalbiruygulama.network.NetworkListener
import com.hacib.duygusalbiruygulama.utils.Util.io

class LoginViewModel(
    private val repository: LoginRepository
) : ViewModel() {
    var userName : String ?= null
    var password : String ?= null
    var user = MutableLiveData<FirebaseUser>()
    var listener: NetworkListener ?= null

    fun getUser() : LiveData<FirebaseUser> = user

    fun loginBtnClick(view: View) {
        println("username - password : $userName - $password")
        listener?.onStart("login request ${Constants.NETWORK_START}")

        var result : AuthResult ?= null

        if (!userName.isNullOrEmpty() && !password.isNullOrEmpty()) {
            io {
                result = repository.loginRequest(userName!!, password!!)
                if (result?.user != null) {
                    listener?.onSuccess("Login succeed ${result?.user!!.uid}")
                } else {
                    listener?.onError("Error while authentication")
                }
                listener?.onFinished("login request ${Constants.NETWORK_FINISHED}")
                user.postValue(result?.user)
            }
        }
    }
}