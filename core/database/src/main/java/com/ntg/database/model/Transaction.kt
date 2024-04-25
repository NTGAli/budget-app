package com.ntg.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant

@Entity(
    tableName = "transaction",
)
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    val amount: String,
    val type: String,
    val date: String,
)

