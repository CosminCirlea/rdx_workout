package com.evolutionsoftware.auther.presentation.pin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.evolutionsoftware.auther.domain.Routes
import com.evolutionsoftware.auther.presentation.main.UiEvent
import org.koin.androidx.compose.getViewModel

@Composable
fun ConfirmPinScreen(navController: NavHostController, viewModel: PinViewModel = getViewModel()) {
    val uiEvent by viewModel.event.collectAsState(initial = null)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        OutlinedTextField(
            value = viewModel.state.confirmPin,
            onValueChange = { viewModel.state = viewModel.state.copy(confirmPin =  it) },
            label = { Text("Confirm PIN") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                if (viewModel.state.confirmPin == viewModel.state.pin) {
                    viewModel.saveUser()
                }
            },
            enabled = viewModel.state.confirmPin == viewModel.state.pin,
            modifier = Modifier.padding(16.dp),
        ) {
            Text(text = "Continue")
        }
    }

    when (uiEvent) {
        is UiEvent.NavigateFurther -> {
            navController.navigate(Routes.MAIN)
        }
        else -> {}
    }
}
