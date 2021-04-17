package com.mjh.myvocaapp.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = [Voca::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vocaDao() : VocaDao
}