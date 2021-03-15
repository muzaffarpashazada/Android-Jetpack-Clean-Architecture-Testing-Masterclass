package com.example.recyclerviewdemo1

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fruitList =
        listOf(
            Fruit("Apples", "Tom"),
            Fruit("Pears", "Johny"),
            Fruit("Oranges", "Hera"),
            Fruit("Grapefruits", "Ares"),
            Fruit("Mandarins", "Dragon"),
            Fruit("Limes", "Titan")
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myRecyclerView.setBackgroundColor(Color.YELLOW)
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.myRecyclerView.adapter = MyRecyclerViewAdapter(fruitList)

    }
}