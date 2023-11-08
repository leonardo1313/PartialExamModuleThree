package com.example.parcijalniispit_trecimodul.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.parcijalniispit_trecimodul.R
import com.example.parcijalniispit_trecimodul.model.Grocery

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var etGroceryName: EditText
    private lateinit var etGroceryCalories: EditText
    private lateinit var groceriesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun displayGroceryList(groceryList: List<Grocery>) {
        val adapter = GroceryAdapter(groceryList)
        groceriesRecyclerView.adapter = adapter
    }

    fun addGroceryToList(view: View) {

    }
}