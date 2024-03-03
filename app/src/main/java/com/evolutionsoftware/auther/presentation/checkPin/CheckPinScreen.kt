package com.evolutionsoftware.auther.presentation.checkPin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.evolutionsoftware.auther.domain.Routes
import com.evolutionsoftware.auther.presentation.main.UiEvent
import org.koin.androidx.compose.getViewModel

@Composable
fun CheckPinScreen(
    navController: NavController,
    viewModel: CheckPinViewModel = getViewModel()
) {
    val uiEvent by viewModel.event.collectAsState(initial = null)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        OutlinedTextField(
            value = viewModel.state.enteredPin,
            onValueChange = { viewModel.state = viewModel.state.copy(enteredPin = it) },
            label = { Text("Enter PIN") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate(Routes.MAIN) {
                    popUpTo(0)
                }
            },
            enabled = viewModel.checkPin()
        ) {
            Text("Continue")
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                viewModel.signOut()
            },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Sign Out")
        }
    }

    when (uiEvent) {
        is UiEvent.NavigateFurther -> {
            navController.navigate(Routes.WELCOME)
        }
        else -> {}
    }
}
