package com.example.parcijalniispit_trecimodul.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcijalniispit_trecimodul.R
import com.example.parcijalniispit_trecimodul.dao.AppDatabase
import com.example.parcijalniispit_trecimodul.model.Grocery
import com.example.parcijalniispit_trecimodul.presenter.MainPresenter
import com.example.parcijalniispit_trecimodul.repository.GroceryRepository

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var etGroceryName: EditText
    private lateinit var etGroceryCalories: EditText
    private lateinit var mainPresenter: MainPresenter
    private lateinit var groceriesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etGroceryName = findViewById(R.id.etGroceryName)
        etGroceryCalories = findViewById(R.id.etGroceryCalories)
        groceriesRecyclerView = findViewById(R.id.rvGroceriesList)
        groceriesRecyclerView.layoutManager = LinearLayoutManager(this)

        val groceryDao = AppDatabase.getInstance(applicationContext).groceryDao()
        val groceryRepository = GroceryRepository(groceryDao)

        mainPresenter = MainPresenter(this, groceryRepository)
        mainPresenter.loadGroceryList()
    }

    override fun displayGroceryList(groceryList: List<Grocery>) {
        val adapter = GroceryAdapter(groceryList, mainPresenter, this)
        groceriesRecyclerView.adapter = adapter
    }

    fun addGroceryToList(view: View) {
        if (isInputValid()) {
            mainPresenter.addGroceryToList(
                etGroceryName.text.toString(),
                etGroceryCalories.text.toString().toInt()
            )
            etGroceryName.setText("")
            etGroceryCalories.setText("")
        }
    }

    private fun isInputValid(): Boolean {
        if (etGroceryName.text.trim().isEmpty()) {
            etGroceryName.error = "Grocery name field is empty. Enter name."
            return false
        } else if (etGroceryCalories.text.trim().isEmpty()) {
            etGroceryCalories.error = "Grocery calories field is empty. Enter calories."
            return false
        }
        return true
    }
}