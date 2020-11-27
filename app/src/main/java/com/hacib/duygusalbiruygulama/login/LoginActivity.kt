package com.hacib.duygusalbiruygulama.login

import android.content.Intent
import android.os.Bundle
import android.service.autofill.UserData
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.hacib.duygusalbiruygulama.R
import com.hacib.duygusalbiruygulama.databinding.ActivityLoginBinding
import com.hacib.duygusalbiruygulama.db.User
import com.hacib.duygusalbiruygulama.db.UserDatabase
import com.hacib.duygusalbiruygulama.db.UserRepository
import com.hacib.duygusalbiruygulama.main.MainModuleActivity
import com.hacib.duygusalbiruygulama.network.NetworkListener
import com.hacib.duygusalbiruygulama.utils.Util
import com.hacib.duygusalbiruygulama.utils.longToast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), NetworkListener, KodeinAware {

    override val kodein by kodein()
    private lateinit var dataBinding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    private val factory : LoginViewModelFactory by instance()
    private val repository : UserRepository by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
        dataBinding.viewModel = viewModel
        viewModel.listener = this

        //println("TEST : " + userDb.getUserDao().getCurrentUser())
    }


    override fun onStart(message: String) {

    }

    override fun onSuccess(message: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {

                repository.insertUser(User(123))
            } catch (e: Exception) {
                println("EXCEPTION : ${e.message}")
            }
        }
        Util.main {
            val intent = Intent(this, MainModuleActivity::class.java)
                .addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK
                            or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
            startActivity(intent)
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