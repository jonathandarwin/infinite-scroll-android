package com.jonathandarwin.infinitescroll.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jonathandarwin.infinitescroll.model.Todo
import com.jonathandarwin.infinitescroll.repository.MainRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class MainViewModel(private val mainRepository: MainRepository) : ViewModel(){

    private val todoList = MutableLiveData<ArrayList<Todo>>()
    private var position = 0

    init{
        todoList.value = ArrayList()
    }

    fun getTodoList() : LiveData<ArrayList<Todo>>{
        return todoList
    }

    fun getData() {
        CoroutineScope(IO).launch {
            var newTodoList = todoList.value
            newTodoList?.addAll(mainRepository.getData(position).await())
            todoList.postValue(newTodoList)

            position += 10
        }
    }
}