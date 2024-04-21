package com.ntg.budgetapp.model.db


data class Transaction(
    val id: Int? = null,
    val title: String,
    val time: String,
    val amount: Int,
    val type: Int,
    val iconId: Int,
    val categoryId: Int,
    val tags: List<Int>? =null,
    val description: String?=null,
)
