package com.mjh.myvocaapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Voca(
    @ColumnInfo(name = "English") var english : String,
    @ColumnInfo(name = "Korean") var korean : String
    )
{
    @PrimaryKey(autoGenerate = true) var id : Int = 0
}
