package com.mjh.myvocaapp.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VocaDao {
    @Query ("SELECT * FROM Voca")
    fun getAll() : LiveData<List<Voca>>

    @Insert
    fun insert(voca : Voca)

    @Update
    fun update(voca : Voca)

    @Delete
    fun delete(voca: Voca)
}