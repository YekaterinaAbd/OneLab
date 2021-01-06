package com.example.onelabhw1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class SecondaryActivity : AppCompatActivity() {

    private val onCLickListener = object : Adapter.OnClickListener {
        override fun onButtonClick(position: Int) {
            Toast.makeText(this@SecondaryActivity, "Position: $position", Toast.LENGTH_SHORT).show()
        }

        override fun onCheckboxClick(position: Int, isChecked: Boolean) {
            (list[position] as Item.CheckboxData).isChecked = isChecked
            Toast.makeText(
                this@SecondaryActivity,
                "Position: $position, IsChecked: $isChecked",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private val adapter: Adapter by lazy {
        Adapter(onCLickListener)
    }

    sealed class Item {
        data class StringData(val string: String) : Item()
        data class ButtonData(val color: Int) : Item()
        data class CheckboxData(var isChecked: Boolean) : Item()
    }

    private val list: MutableList<Item> = mutableListOf(
        Item.StringData("Hello String"),
        Item.ButtonData(R.color.purple_500),
        Item.CheckboxData(true),
        Item.ButtonData(R.color.purple_500),
        Item.StringData("Hello String"),
        Item.CheckboxData(false),
        Item.StringData("Hello String"),
        Item.ButtonData(R.color.purple_500),
        Item.CheckboxData(false),
        Item.StringData("Hello String"),
        Item.ButtonData(R.color.purple_500),
        Item.CheckboxData(false),
        Item.StringData("Hello String"),
        Item.ButtonData(R.color.purple_500),
        Item.CheckboxData(false),
        Item.StringData("Hello String"),
        Item.ButtonData(R.color.purple_500),
        Item.CheckboxData(false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
//        val extra = intent.getStringExtra("EXTRA_1")
//        val text = findViewById<TextView>(R.id.text)
//        text.text = extra

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.list = list
    }
}
