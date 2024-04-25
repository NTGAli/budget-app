package com.ntg.budgetapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ntg.budgetapp.model.countryList
import com.ntg.budgetapp.nav.ScreenPath

@Composable
fun CountrySelectScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(countryList) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(ScreenPath.fieldScreen.passId(it.id))
//                            navController.popBackStack("Main?id={id}",true)
                        }
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(painter = painterResource(id = it.flag), contentDescription = it.name)
//                    Text(text = it.name)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}