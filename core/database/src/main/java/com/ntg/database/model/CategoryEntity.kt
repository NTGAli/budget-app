package com.ntg.database.model

import androidx.room.Entity

@Entity(
    tableName = "category",
)
data class CategoryEntity(
    val id: Int,
    val title: String,
    val icon: String?=null,
    val dateCreated: String,
)
