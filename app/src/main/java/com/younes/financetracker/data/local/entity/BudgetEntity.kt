package com.younes.financetracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budgets")
data class BudgetEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val category: String,

    val limit: Double

)