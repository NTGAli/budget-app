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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ntg.budgetapp.ui.theme.BudgetAppTheme
import com.ntg.components.Button
import com.ntg.components.ButtonSize

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
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                            text = "Test button", loading = click, size = ButtonSize.XL){
                            click = !click
                        }

                        Button(
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                            text = "Test button", loading = click, size = ButtonSize.LG){
                            click = !click
                        }


                        Button(
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                            text = "Test button", loading = click, size = ButtonSize.MD){
                            click = !click
                        }


                        Button(
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                            text = "Test button", loading = click, size = ButtonSize.XS){
                            click = !click
                        }



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