package com.ntg.budgetapp.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ntg.budgetapp.CountrySelectScreen
import com.ntg.budgetapp.TextFieldScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = ScreenPath.fieldScreen.route
    ) {
        composable(
            route = ScreenPath.fieldScreen.route,
            arguments = listOf(
                navArgument(
                  "id"
                ) {
                    type = NavType.IntType
                    defaultValue=0
                },
            )
        ) {
            val id=it.arguments?.getInt("id")
            TextFieldScreen(navController,id)
        }
        composable(
            route = ScreenPath.countryScreen.route,
        ) {
            CountrySelectScreen(navController)
        }
    }
}