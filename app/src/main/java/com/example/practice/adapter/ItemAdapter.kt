package com.example.practice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.R
import com.example.practice.helper.ItemTouchHelperAdapter
import com.example.practice.model.Item
import java.util.*
import kotlin.collections.ArrayList

class ItemAdapter(var context: Context, var items : ArrayList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),ItemTouchHelperAdapter{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if(holder is ItemViewHolder){
            holder.apply {
                tvTitle.text = item.title
            }
        }
    }

    override fun getItemCount(): Int  = items.size

    class ItemViewHolder(view : View) :RecyclerView.ViewHolder(view){
        var tvTitle = view.findViewById<TextView>(R.id.tv_item)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if(fromPosition < toPosition){
            for (i in fromPosition until toPosition)
                Collections.swap(items, i, i + 1)
        }else{
            for (i in fromPosition downTo toPosition)
                Collections.swap(items, i, i - 1)
        }

        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        items.removeAt(position)

        notifyItemRemoved(position)
    }
}