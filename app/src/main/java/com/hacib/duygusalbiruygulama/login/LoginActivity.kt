package com.hacib.duygusalbiruygulama.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.hacib.duygusalbiruygulama.R
import com.hacib.duygusalbiruygulama.databinding.ActivityLoginBinding
import com.hacib.duygusalbiruygulama.network.Firebase
import com.hacib.duygusalbiruygulama.network.NetworkListener
import com.hacib.duygusalbiruygulama.utils.Util
import com.hacib.duygusalbiruygulama.utils.longToast
import com.hacib.duygusalbiruygulama.utils.shortToast

class LoginActivity : AppCompatActivity(), NetworkListener {

    private lateinit var dataBinding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    private val firebase = Firebase()
    private val loginRepository = LoginRepository(firebase)
    private val factory = LoginViewModelFactory(loginRepository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
        dataBinding.viewModel = viewModel
        viewModel.listener = this

        viewModel.getUser().observe(this, {
            //toast(it.uid)
        })
    }

    override fun onStart(message: String) {

    }

    override fun onSuccess(message: String) {
        Util.main {
            shortToast(message)
        }
    }

    override fun onError(message: String) {
        Util.main {
            longToast(message)
        }
    }

    override fun onFinished(message: String) {

    }
}