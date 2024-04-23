package com.ntg.budgetapp.nav

enum class Screen {
    fieldScreen,
    countryScreen,
}

sealed class ScreenPath(val route: String) {
    data object fieldScreen : ScreenPath(
        "${Screen.fieldScreen.name}?id={id}"
    ) {
        fun passId(id: Int): String {
            return this.route.replace(oldValue = "{id}", newValue ="$id")
        }
    }

    data object countryScreen : ScreenPath(Screen.countryScreen.name)

}