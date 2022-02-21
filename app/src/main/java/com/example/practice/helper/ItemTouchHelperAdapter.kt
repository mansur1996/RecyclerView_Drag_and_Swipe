package com.example.practice.helper

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition : Int, toPosition : Int)
    fun onItemDismiss(position : Int)
}