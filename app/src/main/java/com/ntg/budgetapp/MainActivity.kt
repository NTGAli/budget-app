package com.ntg.budgetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ntg.budgetapp.ui.theme.BudgetAppTheme
import com.ntg.budgetapp.ui.theme.ChunLiBlue100
import com.ntg.budgetapp.ui.theme.ChunLiBlue200
import com.ntg.budgetapp.ui.theme.ChunLiBlue300
import com.ntg.budgetapp.ui.theme.ChunLiBlue400
import com.ntg.budgetapp.ui.theme.ChunLiBlue500
import com.ntg.designsystem.components.AmountReport
import com.ntg.designsystem.components.BottomNavigation
import com.ntg.designsystem.components.Button
import com.ntg.designsystem.components.ButtonSize
import com.ntg.designsystem.components.ButtonType
import com.ntg.designsystem.components.Card
import com.ntg.designsystem.components.Chips
import com.ntg.designsystem.components.CircleChart
import com.ntg.designsystem.components.DetailsTable
import com.ntg.designsystem.components.MessageBox
import com.ntg.designsystem.components.TextCheckBox
import com.ntg.designsystem.components.TextDivider
import com.ntg.designsystem.components.TextRadio
import com.ntg.designsystem.components.TransactionItem
import com.ntg.designsystem.model.DonutChartData
import com.ntg.designsystem.model.DonutChartDataCollection
import com.ntg.designsystem.model.NavigationItem
import com.ntg.designsystem.model.TextDividerType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    val isChecked = remember {
                        mutableStateOf(false)
                    }

                    Box {
                        var click by remember {
                            mutableStateOf(false)
                        }
                        LazyColumn {
                            item {

                                com.ntg.designsystem.components.AmountReport(
                                    modifier = Modifier.padding(
                                        horizontal = 32.dp,
                                        vertical = 24.dp
                                    ),
                                    outcome = 10000,
                                    income = 500000
                                )

                                com.ntg.designsystem.components.TextDivider(title = "Helle world")
                                com.ntg.designsystem.components.TextDivider(
                                    modifier = Modifier.padding(vertical = 16.dp),
                                    title = "Helle world",
                                    type = com.ntg.designsystem.model.TextDividerType.CENTER
                                )


                                com.ntg.designsystem.components.TextCheckBox(
                                    title = "Test",
                                    isChecked = isChecked
                                ) {
                                    isChecked.value = !isChecked.value
                                }

                                com.ntg.designsystem.components.TextRadio(
                                    title = "Test Radio",
                                    isChecked = isChecked
                                ) {
                                    isChecked.value = !isChecked.value
                                }


                                com.ntg.designsystem.components.Button(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp),
                                    text = "Test button",
                                    loading = click,
                                    size = com.ntg.designsystem.components.ButtonSize.XL
                                ) {
                                    click = !click
                                }

                                com.ntg.designsystem.components.Button(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp),
                                    text = "Test button",
                                    loading = click,
                                    size = com.ntg.designsystem.components.ButtonSize.LG
                                ) {
                                    click = !click
                                }


                                com.ntg.designsystem.components.Button(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp),
                                    text = "Test button",
                                    loading = click,
                                    size = com.ntg.designsystem.components.ButtonSize.MD
                                ) {
                                    click = !click
                                }


                                com.ntg.designsystem.components.Button(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp),
                                    text = "Test button",
                                    loading = click,
                                    size = com.ntg.designsystem.components.ButtonSize.XS
                                ) {
                                    click = !click
                                }


                                com.ntg.designsystem.components.MessageBox(
                                    modifier = Modifier.padding(top = 16.dp),
                                    text = "Image Backup Available Only with Paid Subscription Plans",
                                    type = com.ntg.designsystem.components.ButtonType.Primary
                                )

                                com.ntg.designsystem.components.MessageBox(
                                    modifier = Modifier.padding(top = 16.dp),
                                    text = "Image Backup Available Only with Paid Subscription Plans",
                                    type = com.ntg.designsystem.components.ButtonType.Secondary
                                )

                                com.ntg.designsystem.components.MessageBox(
                                    modifier = Modifier.padding(top = 16.dp),
                                    text = "Image Backup Available Only with Paid Subscription Plans",
                                    type = com.ntg.designsystem.components.ButtonType.Success
                                )

                                com.ntg.designsystem.components.MessageBox(
                                    modifier = Modifier.padding(top = 16.dp),
                                    text = "Image Backup Available Only with Paid Subscription Plans",
                                    type = com.ntg.designsystem.components.ButtonType.Error
                                )

                                com.ntg.designsystem.components.MessageBox(
                                    modifier = Modifier.padding(top = 16.dp),
                                    text = "Image Backup Available Only with Paid Subscription Plans",
                                    type = com.ntg.designsystem.components.ButtonType.Primary,
                                    textButton = "button"
                                )

                                com.ntg.designsystem.components.MessageBox(
                                    modifier = Modifier.padding(top = 16.dp),
                                    text = "Image Backup Available Only with Paid Subscription Plans",
                                    type = com.ntg.designsystem.components.ButtonType.Primary,
                                    icon = painterResource(
                                        id = R.drawable.diamond
                                    )
                                )

                                com.ntg.designsystem.components.Card(
                                    modifier = Modifier.padding(top = 24.dp),
                                    card = ImageVector.vectorResource(R.drawable.card),
                                    cardNumber = "4111111111111111",
                                    name = "Ali Nateghi",
                                    fullView = click
                                )


                                val viewData = com.ntg.designsystem.model.DonutChartDataCollection(
                                    listOf(
                                        com.ntg.designsystem.model.DonutChartData(
                                            1200.0f,
                                            ChunLiBlue500,
                                            title = "Food & Groceries"
                                        ),
                                        com.ntg.designsystem.model.DonutChartData(
                                            1500.0f,
                                            ChunLiBlue400,
                                            title = "Rent"
                                        ),
                                        com.ntg.designsystem.model.DonutChartData(
                                            300.0f,
                                            ChunLiBlue300,
                                            title = "Gas"
                                        ),
                                        com.ntg.designsystem.model.DonutChartData(
                                            700.0f,
                                            ChunLiBlue200,
                                            title = "Online Purchases"
                                        ),
                                        com.ntg.designsystem.model.DonutChartData(
                                            300.0f,
                                            ChunLiBlue100,
                                            title = "Clothing"
                                        )
                                    )
                                )


                                com.ntg.designsystem.components.CircleChart(
                                    modifier = Modifier.padding(
                                        top = 24.dp
                                    ), data = viewData
                                ) { selected ->
                                    // 3
                                    AnimatedContent(targetState = selected, label = "") {
                                        val amount = it?.amount ?: viewData.totalAmount
                                        val text = it?.title ?: "Total"

                                        // 4
                                        Column(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(
                                                "$${amount}",
                                            )
                                            Text(text)
                                        }
                                    }
                                }


                                com.ntg.designsystem.components.Chips(
                                    modifier = Modifier.padding(top = 24.dp),
                                    title = "From: April 8,2024",
                                    dismiss = true
                                ) {

                                }

                                com.ntg.designsystem.components.Chips(
                                    modifier = Modifier.padding(top = 24.dp),
                                    title = "From: April 8,2024",
                                    dismiss = false
                                ) {

                                }

                                com.ntg.designsystem.components.Chips(
                                    modifier = Modifier.padding(top = 24.dp),
                                    icon = painterResource(id = R.drawable.plus),
                                    dismiss = true
                                ) {

                                }


                                repeat(3){

                                    com.ntg.designsystem.components.TransactionItem(
                                        modifier = Modifier
                                            .padding(horizontal = 16.dp)
                                            .padding(top = 4.dp),
                                        title = "Food & Drink",
                                        time = 1713108246,
                                        amount = 2300,
                                        categoryIcon = painterResource(id = R.drawable.diamond),
                                        onLongCLick = {},
                                        onCLick = {}
                                    )

                                }

                                com.ntg.designsystem.components.DetailsTable(
                                    modifier = Modifier.padding(horizontal = 32.dp),
                                    items = listOf(
                                        Pair("aaa", "aaa"),
                                        Pair("aaa", "aaa"),
                                        Pair("aaa", "aaa"),
                                        Pair("aaa", "aaa")
                                    )
                                )


                                Spacer(modifier = Modifier.padding(290.dp))
                            }
                        }

                        val navs = listOf<com.ntg.designsystem.model.NavigationItem>(
                            com.ntg.designsystem.model.NavigationItem(
                                1,
                                "test",
                                painterResource(id = R.drawable.home),
                                painterResource(id = R.drawable.home),
                                isSelected = true
                            ),
                            com.ntg.designsystem.model.NavigationItem(
                                2,
                                "test",
                                painterResource(id = R.drawable.user_circle),
                                painterResource(id = R.drawable.user_circle),
                                isSelected = false
                            )
                        )

                        com.ntg.designsystem.components.BottomNavigation(
                            modifier = Modifier.align(Alignment.BottomCenter),
                            items = navs,
                            onCLick = {}
                        )
                    }


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BudgetAppTheme {
        Greeting("Android")
    }
}