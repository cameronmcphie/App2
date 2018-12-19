package edu.fullerton.ecs.cpsc411.app2

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Checklist::class], version = 1)
abstract class ChecklistDatabase: RoomDatabase() {
    abstract fun checklistDAO(): ChecklistDAO

    companion object {
        private var instance: ChecklistDatabase? = null
        fun getDatabase(context: Context): ChecklistDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext, ChecklistDatabase::class.java, "ChecklistsDB").allowMainThreadQueries().build()
            }
            return instance as ChecklistDatabase
        }
    }
}