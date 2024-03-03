package com.evolutionsoftware.auther.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.evolutionsoftware.auther.domain.Routes
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(navController: NavHostController, mainViewModel: MainViewModel = getViewModel()) {
    val uiEvent by mainViewModel.event.collectAsState(initial = null)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        mainViewModel.state.user?.let {
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Welcome, ${it.firstName ?: ""}",
                color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Last Name: ${it.name ?: ""}",
                color = Color.White)
            Text(text = "Email: ${it.email ?: ""}",
                color = Color.White)
            Text(text = "Phone: ${it.phone ?: ""}",
                color = Color.White)
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { mainViewModel.signOut() },
                modifier = Modifier.padding(16.dp)) {
                Text(text = "Sign Out")
            }
        }
    }

    when (uiEvent) {
        is UiEvent.NavigateFurther -> {
            navController.navigate(Routes.WELCOME)
        }
        else -> {}
    }
}