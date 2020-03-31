package com.jonathandarwin.infinitescroll.tools

import androidx.recyclerview.widget.DiffUtil
import com.jonathandarwin.infinitescroll.model.Todo

class MainDiffUtil(val oldItem : List<Todo>, val newItem : List<Todo>) : DiffUtil.Callback(){

    override fun getOldListSize(): Int {
        return oldItem.size
    }

    override fun getNewListSize(): Int {
        return newItem.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItem[oldItemPosition].id == newItem[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItem[oldItemPosition].id == newItem[newItemPosition].id
    }
}