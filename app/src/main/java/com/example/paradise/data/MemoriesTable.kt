package com.example.paradise.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "memories_table")
class MemoriesTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "Title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "image") val img: String,
    @ColumnInfo(name = "location") val location: String?
) : Parcelable

