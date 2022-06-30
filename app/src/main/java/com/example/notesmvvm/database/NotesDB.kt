package com.example.notesmvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesmvvm.dao.NotesDAO
import com.example.notesmvvm.data.NotesModel

@Database(entities = [NotesModel::class], version = 1)
abstract class NotesDB : RoomDatabase() {

    abstract fun notesDao(): NotesDAO

    companion object {
        @Volatile
        private var INSTANCE: NotesDB? = null

        fun getDatabase(context: Context): NotesDB {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        NotesDB::class.java,
                        "notes_db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}