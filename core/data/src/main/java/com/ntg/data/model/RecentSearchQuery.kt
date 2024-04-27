
package com.ntg.data.model

import java.time.Clock
import java.time.Instant


data class RecentSearchQuery(
    val query: String,
//    val queriedDate: Instant = System.currentTimeMillis().no,
)

//fun RecentSearchQueryEntity.asExternalModel() = RecentSearchQuery(
//    query = query,
//    queriedDate = queriedDate,
//)
