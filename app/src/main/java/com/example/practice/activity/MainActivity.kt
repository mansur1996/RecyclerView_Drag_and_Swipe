package com.example.practice.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.*
import com.example.practice.R
import com.example.practice.adapter.ItemAdapter
import com.example.practice.helper.SimpleItemTouchHelperCallback
import com.example.practice.model.Item

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews(){
        recyclerView = findViewById(R.id.rv_main)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        refreshAdapter(getAllItems())
    }

    private fun refreshAdapter(items: ArrayList<Item>){
        val adapter = ItemAdapter(this, items)
        recyclerView.adapter = adapter

        val callback = SimpleItemTouchHelperCallback(adapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)

    }

    private fun getAllItems() : ArrayList<Item>{
        val items : ArrayList<Item> = ArrayList()

        for (i in 0..15) items.add(Item("Mansur Mirzayev$i"))

        return items
    }
}