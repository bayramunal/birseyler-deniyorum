package com.hacib.duygusalbiruygulama.login

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.hacib.duygusalbiruygulama.network.Constants
import com.hacib.duygusalbiruygulama.network.NetworkListener
import com.hacib.duygusalbiruygulama.utils.Util.io

class LoginViewModel(
    private val repository: LoginRepository
) : ViewModel() {
    var email: String? = null
    var password: String? = null
    var user = MutableLiveData<FirebaseUser>()
    var listener: NetworkListener? = null

    fun getUser(): LiveData<FirebaseUser> = user

    private fun checkEmailFormat(email: String): Boolean {
        var atCondition = email.contains("@")
        var domainCondition = false
        if (atCondition) {
            val substr = email.split("@")[1]
            domainCondition = substr.contains(".")
        }
        return atCondition && domainCondition
    }

    private fun nullOrEmptyCheck(email: String, password: String) =
        !email.isNullOrEmpty() && !password.isNullOrEmpty()

    fun loginBtnClick(view: View) {
        println("username - password : $email - $password")
        listener?.onStart("login request ${Constants.NETWORK_START}")

        if (
            nullOrEmptyCheck(email!!, password!!)
            && checkEmailFormat(email!!)
            && (password!!.length >= 6)
        ) {
            io {
                try {
                    repository.loginRequest(email!!, password!!)?.user?.let {
                        listener?.onSuccess("Login succeed ${it?.email}")
                        user.postValue(it)
                    }
                } catch (e: FirebaseAuthException) {
                    listener?.onError(e.message!!)
                }
            }
        } else {
            listener?.onError("Your entered wrong formatted e-Mail or your password less than 6 characters")
        }
    }
}