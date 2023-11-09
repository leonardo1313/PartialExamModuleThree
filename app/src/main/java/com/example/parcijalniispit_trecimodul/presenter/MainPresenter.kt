package com.example.parcijalniispit_trecimodul.presenter

import com.example.parcijalniispit_trecimodul.model.Grocery
import com.example.parcijalniispit_trecimodul.repository.GroceryRepository
import com.example.parcijalniispit_trecimodul.view.MainView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(
    private val mainView: MainView,
    private val groceryRepository: GroceryRepository
) {

    fun loadGroceryList() {
        Thread {
            val groceryList = groceryRepository.getAll()
            mainView.displayGroceryList(groceryList)
        }.start()
    }

    fun addGroceryToList(groceryName: String, groceryCalories: Int) {
        val grocery = Grocery(groceryName = groceryName, groceryCalories = groceryCalories)
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                groceryRepository.insert(grocery)
                val groceryList = groceryRepository.getAll()
                withContext(Dispatchers.Main) {
                    mainView.displayGroceryList(groceryList)
                }
            }
        }
    }

    fun deleteGroceryFromList(grocery: Grocery) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                groceryRepository.delete(grocery)
                val groceryList = groceryRepository.getAll()
                withContext(Dispatchers.Main) {
                    mainView.displayGroceryList(groceryList)
                }
            }
        }
    }
}