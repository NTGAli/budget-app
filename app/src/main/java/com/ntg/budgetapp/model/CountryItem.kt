package com.ntg.budgetapp.model

import androidx.annotation.DrawableRes
import com.ntg.budgetapp.R

data class CountryItem(
    val id: Int,
    val name: String,
    @DrawableRes val flag: Int,
)

val countryList = listOf(
    CountryItem(
        id = 1,
        name = "IRAN",
        flag = R.drawable.ic_check_circle
    ),
    CountryItem(
        id = 2,
        name = "USA",
        flag = R.drawable.ic_check_circle
    ),
    CountryItem(
        id = 3,
        name = "GERMANY",
        flag = R.drawable.ic_remove_circle
    ), CountryItem(
        id = 4,
        name = "DUBAI",
        flag = R.drawable.ic_remove_circle
    )
)
