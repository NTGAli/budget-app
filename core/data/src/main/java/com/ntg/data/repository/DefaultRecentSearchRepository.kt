package com.ntg.data.repository

import com.ntg.database.dao.TransactionsDao
import com.ntg.database.model.TransactionEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class DefaultRecentSearchRepository @Inject constructor(
    private val recentSearchQueryDao: TransactionsDao,
) : RecentSearchRepository {
    override suspend fun insertOrReplaceRecentSearch(amount: String, type: String) {
        recentSearchQueryDao.insertOrReplaceTransactions(
            TransactionEntity(
                null,
                amount = amount,
                date = System.currentTimeMillis().toString(),
                type = type
            ),
        )
    }

    override fun getRecentSearchQueries(limit: Int): Flow<List<TransactionEntity>> =
        recentSearchQueryDao.getRecentTransactions(limit).map { searchQueries ->
            searchQueries.map { it }
        }

    override suspend fun clearRecentSearches() = recentSearchQueryDao.clearRecentTransactions()
}
