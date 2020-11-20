package com.hacib.duygusalbiruygulama.utils

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

fun Context.shortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.longToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

object Util {


    /**
     * use for ui operations
     */
    fun main(work: suspend () -> Unit) {
        CoroutineScope(Main).launch {
            work()
        }
    }

    /**
     * use for network operations
     */
    fun io(work: suspend () -> Unit) {
        CoroutineScope(IO).launch {
            work()
        }
    }
}