package com.example.parcijalniispit_trecimodul.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.parcijalniispit_trecimodul.model.Grocery

@Dao
interface GroceryDao {

    @Query("SELECT * FROM Grocery")
    fun getAllGroceries(): List<Grocery>

    @Insert
    suspend fun insertGrocery(grocery: Grocery)

    @Delete
    suspend fun deleteGrocery(grocery: Grocery)
}