package com.ntg.budgetapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
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
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ntg.analytics.AnalyticsHelper
import com.ntg.analytics.LocalAnalyticsHelper
import com.ntg.budgetapp.ui.rememberNiaAppState
import com.ntg.budgetapp.ui.theme.BudgetAppTheme
import com.ntg.budgetapp.ui.theme.ChunLiBlue100
import com.ntg.budgetapp.ui.theme.ChunLiBlue200
import com.ntg.budgetapp.ui.theme.ChunLiBlue300
import com.ntg.budgetapp.ui.theme.ChunLiBlue400
import com.ntg.budgetapp.ui.theme.ChunLiBlue500
import com.ntg.data.repository.UserNewsResourceRepository
import com.ntg.data.util.NetworkMonitor
import com.ntg.designsystem.components.AmountReport
import com.ntg.designsystem.components.BottomNavigation
import com.ntg.designsystem.components.Button
import com.ntg.designsystem.components.ButtonSize
import com.ntg.designsystem.components.ButtonType
import com.ntg.designsystem.components.Card
import com.ntg.designsystem.components.Chips
import com.ntg.designsystem.components.CircleChart
import com.ntg.designsystem.components.DetailsTable
import com.ntg.designsystem.components.ImageItem
import com.ntg.designsystem.components.MessageBox
import com.ntg.designsystem.components.SampleItem
import com.ntg.designsystem.components.Table
import com.ntg.designsystem.components.TextCheckBox
import com.ntg.designsystem.components.TextDivider
import com.ntg.designsystem.components.TextRadio
import com.ntg.designsystem.components.TransactionItem
import com.ntg.designsystem.components.UserData
import com.ntg.designsystem.components.UserDataTable
import com.ntg.designsystem.model.DonutChartData
import com.ntg.designsystem.model.DonutChartDataCollection
import com.ntg.designsystem.model.NavigationItem
import com.ntg.designsystem.model.TableData
import com.ntg.designsystem.model.TextDividerType
import com.ntg.designsystem.model.UserDataTableItem
import com.ntg.model.data.DarkThemeConfig
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var analyticsHelper: AnalyticsHelper

    val viewModel: MainActivityViewModel by viewModels()


//    @Inject
//    lateinit var analyticsHelper: AnalyticsHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        var uiState: MainActivityUiState by mutableStateOf(MainActivityUiState.Loading)

        // Update the uiState
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState
                    .onEach { uiState = it }
                    .collect()
            }
        }

        splashScreen.setKeepOnScreenCondition {
            when (uiState) {
                MainActivityUiState.Loading -> true
                is MainActivityUiState.Success -> false
            }
        }


        enableEdgeToEdge()


        setContent {
            val darkTheme = shouldUseDarkTheme(uiState)

            DisposableEffect(darkTheme) {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.auto(
                        Color.TRANSPARENT,
                        Color.TRANSPARENT,
                    ) { darkTheme },
                    navigationBarStyle = SystemBarStyle.auto(
                        lightScrim,
                        darkScrim,
                    ) { darkTheme },
                )
                onDispose {}
            }

            val appState = rememberNiaAppState(
                windowSizeClass = calculateWindowSizeClass(this),
//                networkMonitor = networkMonitor,
//                userNewsResourceRepository = userNewsResourceRepository,
//                timeZoneMonitor = timeZoneMonitor,
            )

            CompositionLocalProvider(
                LocalAnalyticsHelper provides analyticsHelper,
            ){

                BudgetAppTheme {

                }

            }

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

                                TextFieldScreen(1)

                                Table(
                                    modifier = Modifier.padding(
                                        horizontal = 24.dp,
                                        vertical = 24.dp
                                    ),
                                    items = listOf(
                                        TableData(
                                            0,
                                            painterResource(id = R.drawable.diamond),
                                            "Salary",
                                            "30%",
                                            "20"
                                        ),
                                        TableData(
                                            0,
                                            painterResource(id = R.drawable.diamond),
                                            "Salary",
                                            "30%",
                                            "20"
                                        ),
                                        TableData(
                                            0,
                                            painterResource(id = R.drawable.diamond),
                                            "Salary",
                                            "30%",
                                            "20"
                                        ),
                                        TableData(
                                            0,
                                            painterResource(id = R.drawable.diamond),
                                            "Salary",
                                            "30%",
                                            "20"
                                        )
                                    ),
                                    "Categories", "Count"
                                )

                                ImageItem(
                                    modifier = Modifier.padding(
                                        horizontal = 24.dp,
                                        vertical = 16.dp
                                    )
                                )

                                UserDataTable(
                                    modifier = Modifier.padding(horizontal = 24.dp),
                                    items = listOf(
                                        UserDataTableItem(0, "Full name", "test"),
                                        UserDataTableItem(
                                            0, "Full name", "test", icon = painterResource(
                                                id = R.drawable.mobile
                                            )
                                        ),
                                        UserDataTableItem(0, "Full name", "test", isChecked = true)
                                    )
                                ) {

                                }

                                UserData(email = "test@tt.com", name = "John", state = false)
                                UserData(email = "test@tt.com", name = "John", state = true)
                                UserData(
                                    image = painterResource(id = R.drawable.sample_profile),
                                    email = "test@tt.com",
                                    name = "John",
                                    state = true
                                )


                                SampleItem(
                                    icon = painterResource(id = R.drawable.user_circle),
                                    title = "Account Information"
                                ) {}

                                AmountReport(
                                    modifier = Modifier.padding(
                                        horizontal = 32.dp,
                                        vertical = 24.dp
                                    ),
                                    outcome = 10000,
                                    income = 500000
                                )

                                TextDivider(title = "Helle world")
                                TextDivider(
                                    modifier = Modifier.padding(vertical = 16.dp),
                                    title = "Helle world",
                                    type = TextDividerType.CENTER
                                )


                                TextCheckBox(
                                    title = "Test",
                                    isChecked = isChecked
                                ) {
                                    isChecked.value = !isChecked.value
                                }

                                TextRadio(
                                    title = "Test Radio",
                                    isChecked = isChecked
                                ) {
                                    isChecked.value = !isChecked.value
                                }


                                Button(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp),
                                    text = "Test button",
                                    loading = click,
                                    size = ButtonSize.XL
                                ) {
                                    click = !click
                                }

                                Button(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp),
                                    text = "Test button",
                                    loading = click,
                                    size = ButtonSize.LG
                                ) {
                                    click = !click
                                }


                                Button(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp),
                                    text = "Test button",
                                    loading = click,
                                    size = ButtonSize.MD
                                ) {
                                    click = !click
                                }


                                Button(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp),
                                    text = "Test button",
                                    loading = click,
                                    size = ButtonSize.XS
                                ) {
                                    click = !click
                                }


                                MessageBox(
                                    modifier = Modifier.padding(top = 16.dp),
                                    text = "Image Backup Available Only with Paid Subscription Plans",
                                    type = ButtonType.Primary
                                )

                                MessageBox(
                                    modifier = Modifier.padding(top = 16.dp),
                                    text = "Image Backup Available Only with Paid Subscription Plans",
                                    type = ButtonType.Secondary
                                )

                                MessageBox(
                                    modifier = Modifier.padding(top = 16.dp),
                                    text = "Image Backup Available Only with Paid Subscription Plans",
                                    type = ButtonType.Success
                                )

                                MessageBox(
                                    modifier = Modifier.padding(top = 16.dp),
                                    text = "Image Backup Available Only with Paid Subscription Plans",
                                    type = ButtonType.Error
                                )

                                MessageBox(
                                    modifier = Modifier.padding(top = 16.dp),
                                    text = "Image Backup Available Only with Paid Subscription Plans",
                                    type = ButtonType.Primary,
                                    textButton = "button"
                                )

                                MessageBox(
                                    modifier = Modifier.padding(top = 16.dp),
                                    text = "Image Backup Available Only with Paid Subscription Plans",
                                    type = ButtonType.Primary,
                                    icon = painterResource(
                                        id = R.drawable.diamond
                                    )
                                )

                                Card(
                                    modifier = Modifier.padding(top = 24.dp),
                                    card = ImageVector.vectorResource(R.drawable.card),
                                    cardNumber = "4111111111111111",
                                    name = "Ali Nateghi",
                                    fullView = click
                                )


                                val viewData = DonutChartDataCollection(
                                    listOf(
                                        DonutChartData(
                                            1200.0f,
                                            ChunLiBlue500,
                                            title = "Food & Groceries"
                                        ),
                                        DonutChartData(
                                            1500.0f,
                                            ChunLiBlue400,
                                            title = "Rent"
                                        ),
                                        DonutChartData(
                                            300.0f,
                                            ChunLiBlue300,
                                            title = "Gas"
                                        ),
                                        DonutChartData(
                                            700.0f,
                                            ChunLiBlue200,
                                            title = "Online Purchases"
                                        ),
                                        DonutChartData(
                                            300.0f,
                                            ChunLiBlue100,
                                            title = "Clothing"
                                        )
                                    )
                                )


                                CircleChart(
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


                                Chips(
                                    modifier = Modifier.padding(top = 24.dp),
                                    title = "From: April 8,2024",
                                    dismiss = true
                                ) {

                                }

                                Chips(
                                    modifier = Modifier.padding(top = 24.dp),
                                    title = "From: April 8,2024",
                                    dismiss = false
                                ) {

                                }

                                Chips(
                                    modifier = Modifier.padding(top = 24.dp),
                                    icon = painterResource(id = R.drawable.plus),
                                    dismiss = true
                                ) {

                                }


                                repeat(3) {

                                    TransactionItem(
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

                                DetailsTable(
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

                        val navs = listOf<NavigationItem>(
                            NavigationItem(
                                1,
                                "test",
                                painterResource(id = R.drawable.home),
                                painterResource(id = R.drawable.home),
                                isSelected = true
                            ),
                            NavigationItem(
                                2,
                                "test",
                                painterResource(id = R.drawable.user_circle),
                                painterResource(id = R.drawable.user_circle),
                                isSelected = false
                            )
                        )

                        BottomNavigation(
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
private fun shouldUseDarkTheme(
    uiState: MainActivityUiState,
): Boolean = when (uiState) {
    MainActivityUiState.Loading -> isSystemInDarkTheme()
    is MainActivityUiState.Success -> when (uiState.userData.darkThemeConfig) {
        DarkThemeConfig.FOLLOW_SYSTEM -> isSystemInDarkTheme()
        DarkThemeConfig.LIGHT -> false
        DarkThemeConfig.DARK -> true
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

/**
 * The default light scrim, as defined by androidx and the platform:
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:activity/activity/src/main/java/androidx/activity/EdgeToEdge.kt;l=35-38;drc=27e7d52e8604a080133e8b842db10c89b4482598
 */
private val lightScrim = android.graphics.Color.argb(0xe6, 0xFF, 0xFF, 0xFF)

/**
 * The default dark scrim, as defined by androidx and the platform:
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:activity/activity/src/main/java/androidx/activity/EdgeToEdge.kt;l=40-44;drc=27e7d52e8604a080133e8b842db10c89b4482598
 */
private val darkScrim = android.graphics.Color.argb(0x80, 0x1b, 0x1b, 0x1b)