package com.ntg.insert_transaction.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.ntg.insert_transaction.TransactionInputRute

const val IS_EDIT = "isEdit"
const val TransactionInput_Route = "transaction_input_route/{$IS_EDIT}"


fun NavGraphBuilder.transactionInputScreen() {
    composable(
        route = TransactionInput_Route,
        arguments = listOf(
            navArgument(IS_EDIT) { type = NavType.BoolType },
        ),
    ) {
        TransactionInputRute()
    }
}
