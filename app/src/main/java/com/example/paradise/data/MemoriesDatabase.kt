package com.example.paradise.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = arrayOf(MemoriesTable::class), version = 2, exportSchema = false)
abstract class MemoriesDatabase : RoomDatabase() {

    abstract fun getMemoriesDao() : MemoriesDao

    companion object {

        private var INSTANCE: MemoriesDatabase? = null

        val migration_1_2: Migration = object: Migration(1 ,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE memories_table ADD COLUMN location TEXT DEFAULT ''")
            }

        }

        fun getDatabase(context : Context) : MemoriesDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MemoriesDatabase::class.java,
                    "memories_database"
                )
                        .addMigrations(migration_1_2)
                        .allowMainThreadQueries()
                        .build()
                INSTANCE = instance
                instance
            }

        }

    }

}