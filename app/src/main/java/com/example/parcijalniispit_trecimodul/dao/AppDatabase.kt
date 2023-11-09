package com.example.parcijalniispit_trecimodul.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcijalniispit_trecimodul.model.Grocery

@Database(entities = [Grocery::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun groceryDao(): GroceryDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()
        }
    }
}