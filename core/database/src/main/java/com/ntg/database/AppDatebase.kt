package com.ntg.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ntg.database.dao.CategoryDao
import com.ntg.database.dao.TransactionsDao
import com.ntg.database.model.CategoryEntity
import com.ntg.database.model.TransactionEntity


@Database(
    entities = [
        TransactionEntity::class,
        CategoryEntity::class
    ],
    version = 2,
    exportSchema = true,
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionsDao
    abstract fun categoryDao(): CategoryDao

}