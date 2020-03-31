package com.jonathandarwin.infinitescroll.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.jonathandarwin.infinitescroll.factory.ViewModelFactory

open class BaseActivity<VM : ViewModel, DB : ViewDataBinding>(val vm : Class<VM>, val layout : Int) : AppCompatActivity(){

    private lateinit var viewModel : VM
    private lateinit var binding : DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(application)).get(vm)
        binding = DataBindingUtil.setContentView(this, layout)
    }


    fun getViewModel() : VM {
        return viewModel
    }

    fun getBinding() : DB{
        return binding
    }
}