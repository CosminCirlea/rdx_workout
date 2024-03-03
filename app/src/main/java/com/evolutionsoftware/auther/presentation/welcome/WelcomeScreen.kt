package com.evolutionsoftware.auther.presentation.welcome

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.evolutionsoftware.auther.domain.Routes

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Welcome to Auther",
            modifier = Modifier.padding(bottom = 32.dp),
            color = Color.White
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navController.navigate(Routes.TERMS) },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(text = "Continue")
        }
    }
}