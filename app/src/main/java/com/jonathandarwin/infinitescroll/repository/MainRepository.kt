package com.jonathandarwin.infinitescroll.repository

import com.jonathandarwin.infinitescroll.model.Todo
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class MainRepository{

     fun getData(position : Int) : Deferred<List<Todo>> {
        return CoroutineScope(IO).async {
            val todoList = ArrayList<Todo>()
            delay(1000)
            for(i in position+1..position+10) {
                todoList.add(Todo(i, "Title $i", "Description $i"))
            }

            todoList
        }
    }
}