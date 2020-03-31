package com.jonathandarwin.infinitescroll.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jonathandarwin.infinitescroll.R
import com.jonathandarwin.infinitescroll.databinding.ListTodoItemBinding
import com.jonathandarwin.infinitescroll.model.Todo
import com.jonathandarwin.infinitescroll.tools.MainDiffUtil

class MainAdapter() : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    var todoList : ArrayList<Todo> = ArrayList()

    class MainViewHolder(val binding : ListTodoItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(todo : Todo){
            binding.viewModel = todo
        }
    }

    fun updateData(newItem : List<Todo>){
        val diffUtil = MainDiffUtil(todoList, newItem)
        val diffResult = DiffUtil.calculateDiff(diffUtil)

        todoList.clear()
        todoList.addAll(newItem)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_todo_item, parent, false))
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(todoList[position])
    }
}