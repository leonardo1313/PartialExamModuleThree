package com.example.parcijalniispit_trecimodul.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcijalniispit_trecimodul.R
import com.example.parcijalniispit_trecimodul.model.Grocery

class GroceryAdapter(private val groceryList: List<Grocery>) : RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val groceryItemView =LayoutInflater.from(parent.context).inflate(R.layout.grocery_item, parent, false)
        return CustomViewHolder(groceryItemView)
    }

    override fun getItemCount(): Int = groceryList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.groceryName.text = groceryList[position].groceryName
        holder.groceryCalories.text = groceryList[position].groceryCalories.toString()
    }

}

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val groceryName: TextView = itemView.findViewById(R.id.tvGroceryName)
    val groceryCalories: TextView = itemView.findViewById(R.id.tvGroceryCalories)
}