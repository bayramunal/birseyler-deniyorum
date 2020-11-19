package com.hacib.duygusalbiruygulama.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.hacib.duygusalbiruygulama.R
import com.hacib.duygusalbiruygulama.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var dataBinding : ActivityLoginBinding
    private lateinit var viewModel : LoginViewModel
    private val factory = LoginViewModelFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
        dataBinding.viewModel = viewModel
    }
}