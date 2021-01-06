package com.example.onelabhw1.view_model_sample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.onelabhw1.R

class LiveDataActivity : AppCompatActivity() {

    private val viewModel: LiveDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.live_data_activity)
        supportFragmentManager.beginTransaction().add(R.id.frame1, FirstFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.frame2, SecondFragment()).commit()

        viewModel.liveData.value = "Hello LiveData!!"
    }
}