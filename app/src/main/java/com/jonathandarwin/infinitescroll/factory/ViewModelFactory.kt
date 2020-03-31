package com.jonathandarwin.infinitescroll.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jonathandarwin.infinitescroll.di.Injection
import com.jonathandarwin.infinitescroll.ui.MainViewModel

class ViewModelFactory(private val application: Application) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(Injection.provideMainRepository()) as T
        }

        return null as T
    }
}