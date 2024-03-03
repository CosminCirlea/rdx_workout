package com.evolutionsoftware.auther.presentation.splash

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.evolutionsoftware.auther.domain.Routes
import org.koin.androidx.compose.getViewModel

@Composable
fun SplashScreen(navController: NavHostController, viewModel: SplashViewModel = getViewModel()) {
    if (viewModel.state.user != null) {
        navController.navigate(Routes.CHECK_PIN)
    } else {
        navController.navigate(Routes.WELCOME)
    }
}