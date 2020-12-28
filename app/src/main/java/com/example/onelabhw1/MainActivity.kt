package com.example.onelabhw1

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        //createString()
        //checkPermission()
        requestPermission()
    }

    private fun bindViews() {
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            // openSecondaryActivity()
            showAlertDialog()
        }
    }

    private fun createString() {
        val myString = createString {
            append(", Hello!")
            appendLn("Nice to meet you!")
        }
        logI(myString)
    }

    private fun requestPermission() {
        if (!checkPermission())
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                1
            )
    }

    private fun checkPermission(): Boolean {
        val hasReadContactPermission =
            (this as Context).checkPermission(android.Manifest.permission.READ_CONTACTS)
        logI(hasReadContactPermission)
        return hasReadContactPermission
    }

    private fun openSecondaryActivity() {
        val intent = intentFor<SecondaryActivity>(
            "EXTRA_1" to "value1",
            "EXTRA_2" to 2
        )
        startActivity(intent)
    }

    private fun showAlertDialog() {
        showDialog {
            title(R.string.app_name)
            description("This is Description!")
            positiveButton(R.string.default_web_client_id) onCLick {
                Toast.makeText(this@MainActivity, "Alert text", Toast.LENGTH_SHORT).show()
                it.dismiss()
            }
        }
    }
}
