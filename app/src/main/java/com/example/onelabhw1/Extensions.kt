package com.example.onelabhw1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED
import androidx.core.content.PermissionChecker.checkCallingOrSelfPermission

fun <T> logI(text: T) {
    Log.i("information", text.toString())
}

fun Context.checkPermission(permission: String): Boolean {
    return checkCallingOrSelfPermission(this, permission) == PERMISSION_GRANTED
}

inline fun <reified T : Activity> Context.intentFor(vararg args: Pair<String, Any?>): Intent {
    val intent = Intent(this, T::class.java)
    for ((key, value) in args) {
        when (value) {
            is String -> intent.putExtra(key, value)
            is Int -> intent.putExtra(key, value)
        }
    }
    return intent
}

