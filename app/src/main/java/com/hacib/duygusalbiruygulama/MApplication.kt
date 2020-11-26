package com.hacib.duygusalbiruygulama

import android.app.Application
import com.hacib.duygusalbiruygulama.db.UserDatabase
import com.hacib.duygusalbiruygulama.db.UserRepository
import com.hacib.duygusalbiruygulama.login.LoginRepository
import com.hacib.duygusalbiruygulama.login.LoginViewModelFactory
import com.hacib.duygusalbiruygulama.network.Firebase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import org.kodein.di.generic.provider

class MApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MApplication))

        bind() from singleton { Firebase() }
        bind() from singleton { UserDatabase(instance()) }
        bind() from singleton { UserRepository(instance()) }
        bind() from provider { LoginRepository(instance()) }
        bind() from provider { LoginViewModelFactory(instance()) }
    }
}