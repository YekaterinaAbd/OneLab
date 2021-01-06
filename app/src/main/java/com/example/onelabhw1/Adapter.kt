package com.example.onelabhw1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onelabhw1.SecondaryActivity.Item

class Adapter(
    val onClickListener: OnClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: List<Item> = emptyList()

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is Item.StringData -> R.layout.view_text
            is Item.CheckboxData -> R.layout.view_checkbox
            is Item.ButtonData -> R.layout.view_button
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.view_text -> TextViewHolder(inflater.inflate(viewType, parent, false))
            R.layout.view_checkbox -> CheckboxViewHolder(inflater.inflate(viewType, parent, false))
            R.layout.view_button -> ButtonViewHolder(inflater.inflate(viewType, parent, false))
            else -> throw Exception()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TextViewHolder -> holder.bind(list[position] as Item.StringData)
            is CheckboxViewHolder -> holder.bind(list[position] as Item.CheckboxData)
            is ButtonViewHolder -> holder.bind(list[position] as Item.ButtonData)
        }
    }

    override fun getItemCount(): Int = list.size


    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textView: TextView = view.findViewById(R.id.textView)

        fun bind(stringData: Item.StringData) {
            textView.text = stringData.string
        }
    }

    inner class CheckboxViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val checkbox: CheckBox = view.findViewById(R.id.checkbox)

        fun bind(checkboxData: Item.CheckboxData) {
            checkbox.isChecked = checkboxData.isChecked
            checkbox.setOnCheckedChangeListener { _, b ->
                onClickListener.onCheckboxClick(adapterPosition, b)
            }
        }
    }

    inner class ButtonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val button: Button = view.findViewById(R.id.button)

        fun bind(buttonData: Item.ButtonData) {
            button.setBackgroundColor(buttonData.color)
            button.setOnClickListener {
                onClickListener.onButtonClick(adapterPosition)
            }
        }
    }

    interface OnClickListener {
        fun onButtonClick(position: Int)
        fun onCheckboxClick(position: Int, isChecked: Boolean)
    }

}