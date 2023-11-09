package com.example.parcijalniispit_trecimodul.view

import android.app.AlertDialog
import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcijalniispit_trecimodul.R
import com.example.parcijalniispit_trecimodul.model.Grocery
import com.example.parcijalniispit_trecimodul.presenter.MainPresenter

class GroceryAdapter(
    private val groceryList: List<Grocery>,
    private val mainPresenter: MainPresenter,
    private val context: Context
) :
    RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val groceryItemView =
            LayoutInflater.from(parent.context).inflate(R.layout.grocery_item, parent, false)
        return CustomViewHolder(groceryItemView)
    }

    override fun getItemCount(): Int = groceryList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.groceryName.text = groceryList[position].groceryName
        holder.groceryCalories.text = groceryList[position].groceryCalories.toString() + " kcal"
        holder.llGroceryItem.setOnClickListener {
            val alertDialog = AlertDialog.Builder(context)
            alertDialog.apply {
                setTitle("Remove grocery")
                setMessage("Are you sure you want to remove grocery from the list?")
                setPositiveButton("Yes") { dialog, id ->
                    mainPresenter.deleteGroceryFromList(groceryList[position])
                }
                setNegativeButton("No") { dialog, id ->

                }
            }.create().show()
        }
    }
}

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val groceryName: TextView = itemView.findViewById(R.id.tvGroceryName)
    val groceryCalories: TextView = itemView.findViewById(R.id.tvGroceryCalories)
    val llGroceryItem: LinearLayout = itemView.findViewById(R.id.linearLayoutGroceryItem)
}