package com.example.onelabhw1

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
        val i = intent.getStringExtra("EXTRA_1")
        val text = findViewById<TextView>(R.id.text)
        text.text = i
    }
}
