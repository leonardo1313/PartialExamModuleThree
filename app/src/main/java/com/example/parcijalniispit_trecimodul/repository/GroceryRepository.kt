package com.example.parcijalniispit_trecimodul.repository

import com.example.parcijalniispit_trecimodul.dao.GroceryDao
import com.example.parcijalniispit_trecimodul.model.Grocery

class GroceryRepository(private val groceryDao: GroceryDao) {

    fun getAll(): List<Grocery> {
        return groceryDao.getAllGroceries()
    }

    suspend fun insert(grocery: Grocery) {
        groceryDao.insertGrocery(grocery)
    }

    suspend fun delete(grocery: Grocery) {
        groceryDao.deleteGrocery(grocery)
    }
}