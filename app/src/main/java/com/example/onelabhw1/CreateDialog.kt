package com.example.onelabhw1

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Button
import androidx.annotation.StringRes

class MyAlertDialogBuilder(private val context: Context) {

    val dialogBuilder = AlertDialog.Builder(context)

//    lateinit var title: String
//    lateinit var description: String
//    lateinit var positiveButton: Button

    fun title(@StringRes titleId: Int) {
        //title = context.getString(titleId)
        dialogBuilder.setTitle(dialogBuilder.context.getString(titleId))
    }

    fun title(title: String) {
        //this.title = title
        dialogBuilder.setTitle(title)
    }

    fun description(description: String) {
        //this.description = description
        dialogBuilder.setMessage(description)
    }

//    fun positiveButton(@StringRes textResource: Int, func: (DialogInterface) -> Unit) {
//        dialogBuilder.setPositiveButton(textResource, func)
//    }

//    fun positiveButton(@StringRes textResource: Int, f: (DialogInterface) -> Unit): Button {
//        with(positiveButton) {
//            text = context.getString(textResource)
//        }
//        return positiveButton
//    }

//    infix fun onCLick(block: (DialogInterface) -> Unit) {
//
//        //dialogBuilder.setPositiveButton("Hello", block)
//    }

    infix fun AlertDialog.Builder.onCLick(block: (DialogInterface) -> Unit): DialogInterface.OnClickListener {
        return DialogInterface.OnClickListener { p0, p1 ->
            if (p0 != null) {
                block(p0)
            }
        }
        //dialogBuilder.setPositiveButton("Hello", block)
    }
}

fun Context.showDialog(f: MyAlertDialogBuilder.() -> Unit) {
    val builder = MyAlertDialogBuilder(this)
    builder.f()
    builder.dialogBuilder.show()
}





