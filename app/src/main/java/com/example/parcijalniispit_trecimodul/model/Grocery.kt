package com.example.parcijalniispit_trecimodul.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Grocery(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val groceryName: String,
    val groceryCalories: Int
)