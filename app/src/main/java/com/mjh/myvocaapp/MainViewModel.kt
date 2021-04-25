package com.mjh.myvocaapp

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.mjh.myvocaapp.model.AppDatabase
import com.mjh.myvocaapp.model.Voca

class MainViewModel(application: Application) : AndroidViewModel(application) {

    //val loadingLiveData = MutableLiveData<Boolean>()
    //val itemsLiveData = MutableLiveData<List<Voca>>()
    /*class Factory(val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(application) as T
        }
    }*/

    private val db = Room.databaseBuilder(application, AppDatabase::class.java,"VocaDB").build()

    fun getAll() : LiveData<List<Voca>> {
        return db.vocaDao().getAll()
    }

    suspend fun insert(voca : Voca)
    {
        db.vocaDao().insert(voca)
    }
}