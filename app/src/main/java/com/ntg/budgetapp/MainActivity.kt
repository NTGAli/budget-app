package com.ntg.budgetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ntg.budgetapp.ui.theme.BudgetAppTheme
import com.ntg.components.Button
import com.ntg.components.ButtonSize
import com.ntg.components.ButtonType
import com.ntg.components.Card
import com.ntg.components.MessageBox

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

                    var click by remember {
                        mutableStateOf(false)
                    }
                    Column {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            text = "Test button", loading = click, size = ButtonSize.XL){
                            click = !click
                        }

                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            text = "Test button", loading = click, size = ButtonSize.LG){
                            click = !click
                        }


                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            text = "Test button", loading = click, size = ButtonSize.MD){
                            click = !click
                        }


                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            text = "Test button", loading = click, size = ButtonSize.XS){
                            click = !click
                        }


                        MessageBox(
                            modifier = Modifier.padding(top = 16.dp),
                            text = "Image Backup Available Only with Paid Subscription Plans", type = ButtonType.Primary)

                        MessageBox(
                            modifier = Modifier.padding(top = 16.dp),
                            text = "Image Backup Available Only with Paid Subscription Plans", type = ButtonType.Secondary)

                        MessageBox(
                            modifier = Modifier.padding(top = 16.dp),
                            text = "Image Backup Available Only with Paid Subscription Plans", type = ButtonType.Success)

                        MessageBox(
                            modifier = Modifier.padding(top = 16.dp),
                            text = "Image Backup Available Only with Paid Subscription Plans", type = ButtonType.Error)

                        MessageBox(
                            modifier = Modifier.padding(top = 16.dp),
                            text = "Image Backup Available Only with Paid Subscription Plans", type = ButtonType.Primary, textButton = "button")

                        MessageBox(
                            modifier = Modifier.padding(top = 16.dp),
                            text = "Image Backup Available Only with Paid Subscription Plans", type = ButtonType.Primary, icon = painterResource(
                                id = R.drawable.diamond
                            ))

                        Card(card = ImageVector.vectorResource(R.drawable.card))
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