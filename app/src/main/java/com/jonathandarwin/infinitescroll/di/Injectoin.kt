package com.jonathandarwin.infinitescroll.di

import com.jonathandarwin.infinitescroll.repository.MainRepository

class Injection{

    companion object {
        fun provideMainRepository() : MainRepository{
            return MainRepository()
        }
    }
}