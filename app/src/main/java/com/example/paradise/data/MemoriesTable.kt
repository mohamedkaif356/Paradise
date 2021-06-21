package com.example.paradise.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memories_table")
class MemoriesTable(

    @ColumnInfo(name = "Title") val title : String,
    @ColumnInfo(name = "description") val description : String,
    @ColumnInfo(name = "date") val date : String,
    @ColumnInfo(name = "image") val img : String,
    @ColumnInfo(name = "location") val location : String?

) {

    @PrimaryKey(autoGenerate = true) var id = 0

}