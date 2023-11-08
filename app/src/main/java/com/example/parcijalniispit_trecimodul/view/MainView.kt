package com.example.parcijalniispit_trecimodul.view

import com.example.parcijalniispit_trecimodul.model.Grocery

interface MainView {

    fun displayGroceryList(groceryList: List<Grocery>)
}