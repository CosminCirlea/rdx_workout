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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.evolutionsoftware.auther.domain.Routes
import org.koin.androidx.compose.getViewModel

@Composable
fun PinScreen(navController: NavHostController, viewModel: PinViewModel = getViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        OutlinedTextField(
            value = viewModel.state.pin,
            onValueChange = { viewModel.state = viewModel.state.copy(pin =  it) },
            label = { Text("Enter New PIN") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                if (viewModel.state.pin.isNotBlank()) {
                    navController.navigate(Routes.PIN_CONFIRMATION)
                }
            },
            enabled = viewModel.state.pin.isNotBlank(),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Continue")
        }
    }
}