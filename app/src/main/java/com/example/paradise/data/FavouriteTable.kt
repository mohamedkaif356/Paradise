package com.example.paradise.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "favourite_table")
data class FavouriteTable(

    @PrimaryKey(autoGenerate = true)
    val favId: Int,
    val id: Int,
    @ColumnInfo(name = "Title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "image") val img: String,
    @ColumnInfo(name = "location") val location: String?

) : Serializable
