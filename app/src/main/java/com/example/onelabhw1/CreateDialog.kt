package com.example.onelabhw1

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import androidx.annotation.StringRes

class MyAlertDialogBuilder(private val context: Context) {

    val dialogBuilder = AlertDialog.Builder(context)

    fun title(@StringRes titleId: Int) {
        dialogBuilder.setTitle(dialogBuilder.context.getString(titleId))
    }

    fun description(description: String) {
        dialogBuilder.setMessage(description)
    }

    fun positiveButton(@StringRes textResource: Int): String {
        return context.getString(textResource)
    }

    infix fun String.onCLick(block: (DialogInterface) -> Unit) {
        val listener = DialogInterface.OnClickListener { p0, _ ->
            if (p0 != null) {
                block(p0)
            }
        }
        dialogBuilder.setPositiveButton(this, listener)
    }
}

fun Context.showDialog(block: MyAlertDialogBuilder.() -> Unit) {
    val builder = MyAlertDialogBuilder(this)
    builder.block()
    builder.dialogBuilder.show()
}





