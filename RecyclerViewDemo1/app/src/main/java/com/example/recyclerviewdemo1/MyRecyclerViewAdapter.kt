package com.example.recyclerviewdemo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
    private val fruitList: List<Fruit>,
    private val clickListener: (Fruit) -> Unit
) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(fruitList[position], clickListener)
    }

}

class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val nameTextView: TextView = view.findViewById(R.id.name_text_view)

    fun bind(fruit: Fruit, clickListener: (Fruit) -> Unit) {
        nameTextView.text = fruit.name
        view.setOnClickListener {
            clickListener.invoke(fruit)
        }
    }

}