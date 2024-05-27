package com.ntg.budgetapp.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.ntg.budgetapp.ui.NiaAppState
import com.ntg.home.navigation.Home_Route
import com.ntg.home.navigation.homeScreen
import com.ntg.insert_transaction.navigation.TransactionInput_Route
import com.ntg.insert_transaction.navigation.transactionInputScreen
import com.ntg.setup.navigation.Currency_Route
import com.ntg.setup.navigation.setupScreen

@Composable
fun BudgetNavHost(
    appState: NiaAppState,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
    startDestination: String = TransactionInput_Route,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen()
        setupScreen()
        transactionInputScreen()
//        homeScreen(onTopicClick = navController::navigateToInterests)
//        bookmarksScreen(
//            onTopicClick = navController::navigateToInterests,
//            onShowSnackbar = onShowSnackbar,
//        )
//        searchScreen(
//            onBackClick = navController::popBackStack,
//            onInterestsClick = { appState.navigateToTopLevelDestination(INTERESTS) },
//            onTopicClick = navController::navigateToInterests,
//        )
//        interestsListDetailScreen()
    }
}
