package com.jonathandarwin.infinitescroll.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jonathandarwin.infinitescroll.R
import com.jonathandarwin.infinitescroll.base.BaseActivity
import com.jonathandarwin.infinitescroll.databinding.MainActivityBinding

class MainActivity : BaseActivity<MainViewModel, MainActivityBinding>
    (MainViewModel::class.java, R.layout.main_activity) {

    lateinit var adapter : MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAdapter()
        setListener()
        requestData()

        getBinding().nestedScrollView.setOnScrollChangeListener{
            v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
                val view = v?.getChildAt(v?.childCount - 1) as View
                val diff = view.bottom - (v.height + v.scrollY)

            if(diff == 0){
                requestData()
            }
        }
    }

    private fun setAdapter(){
        adapter = MainAdapter()
        getBinding().recyclerView.layoutManager = LinearLayoutManager(this)
        getBinding().recyclerView.adapter = adapter
    }

    private fun setListener(){
        getViewModel().getTodoList().observe(this, Observer {
            todoList ->
                getBinding().loading.visibility = View.GONE
                if(todoList != null){
                    adapter.updateData(todoList)
                }
        })
    }

    private fun requestData(){
        getBinding().loading.visibility = View.VISIBLE
        getViewModel().getData()
    }
}
