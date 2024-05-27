package com.ntg.setup.navigation

import android.icu.util.Currency
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ntg.setup.CurrencyRoute
import com.ntg.setup.CurrencyScreen
import com.ntg.setup.SetupRoute

const val IS_EDIT = "isEdit"
const val Setup_Route = "setup_route/{$IS_EDIT}"
const val Currency_Route = "currency_route/"


fun NavGraphBuilder.setupScreen() {
    composable(
        route = Setup_Route,
        arguments = listOf(
            navArgument(IS_EDIT) { type = NavType.BoolType },
        ),
    ) {
        SetupRoute()
    }


    composable(
        route = Currency_Route
    ){
        CurrencyRoute()
    }
}
