package com.evolutionsoftware.auther

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.evolutionsoftware.auther.domain.Routes
import com.evolutionsoftware.auther.presentation.checkPin.CheckPinScreen
import com.evolutionsoftware.auther.presentation.credentials.CredentialsScreen
import com.evolutionsoftware.auther.presentation.main.GradientSurface
import com.evolutionsoftware.auther.presentation.main.MainScreen
import com.evolutionsoftware.auther.presentation.personalInfo.PersonalInfoScreen
import com.evolutionsoftware.auther.presentation.pin.ConfirmPinScreen
import com.evolutionsoftware.auther.presentation.pin.PinScreen
import com.evolutionsoftware.auther.presentation.pin.PinViewModel
import com.evolutionsoftware.auther.presentation.splash.SplashScreen
import com.evolutionsoftware.auther.presentation.termsOfService.TermsScreen
import com.evolutionsoftware.auther.presentation.welcome.WelcomeScreen
import com.evolutionsoftware.auther.ui.theme.AutherTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AutherTheme {
                GradientSurface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val pinViewModel: PinViewModel = getViewModel()
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.SPLASH) {
                        composable(Routes.SPLASH) {
                            SplashScreen(navController)
                        }
                        composable(Routes.CHECK_PIN) {
                            CheckPinScreen(navController)
                        }
                        composable(Routes.MAIN) {
                            MainScreen(navController)
                        }
                        composable(Routes.WELCOME) {
                            WelcomeScreen(navController = navController)
                        }
                        composable(Routes.TERMS) {
                            TermsScreen(navController = navController)
                        }
                        composable(Routes.CREDENTIALS) {
                            CredentialsScreen(navController = navController)
                        }
                        composable(Routes.PERSONAL_INFO) {
                            PersonalInfoScreen(navController = navController)
                        }
                        composable(Routes.PIN) {
                            PinScreen(navController = navController, pinViewModel)
                        }
                        composable(Routes.PIN_CONFIRMATION) {
                            ConfirmPinScreen(navController = navController, pinViewModel)
                        }
                    }
                }
            }
        }
    }
}