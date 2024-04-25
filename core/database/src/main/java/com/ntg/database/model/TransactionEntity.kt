package com.ntg.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "transaction",
)
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    val amount: String,
    val type: String,
    val date: String,
)

