package com.ntg.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ntg.database.model.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionsDao {
    @Query(value = "SELECT * FROM transaction ORDER BY date DESC LIMIT :limit")
    fun getRecentTransactions(limit: Int): Flow<List<Transaction>>

    @Upsert
    suspend fun insertOrReplaceTransactions(transaction: Transaction)

    @Query(value = "DELETE FROM transaction")
    suspend fun clearRecentTransactions()
}
