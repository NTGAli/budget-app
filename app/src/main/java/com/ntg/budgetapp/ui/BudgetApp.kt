package com.ntg.budgetapp.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import com.ntg.budgetapp.nav.TopLevelDestination
import com.ntg.designsystem.components.scrollbar.BudgetBackground

@Composable
fun BudgetApp(appState: NiaAppState, modifier: Modifier = Modifier) {

    var showSettingsDialog by rememberSaveable { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }


    BudgetBackground(modifier = modifier) {
        BudgetApp(
            appState = appState,
            snackbarHostState = snackbarHostState,
            showSettingsDialog = showSettingsDialog,
            onSettingsDismissed = { showSettingsDialog = false },
            onTopAppBarActionClick = { showSettingsDialog = true },
        )
    }
}


@Composable
internal fun BudgetApp(
    appState: NiaAppState,
    snackbarHostState: SnackbarHostState,
    showSettingsDialog: Boolean,
    onSettingsDismissed: () -> Unit,
    onTopAppBarActionClick: () -> Unit,
    modifier: Modifier = Modifier,
) {


    Scaffold(
        modifier = modifier.semantics {
            testTagsAsResourceId = true
        },
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            if (appState.shouldShowBottomBar) {
                AppBottomBar(
                    destinations = appState.topLevelDestinations,
                    destinationsWithUnreadResources = unreadDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination,
                    modifier = Modifier.testTag("NiaBottomBar"),
                )
            }
        },
    ){

    }

}