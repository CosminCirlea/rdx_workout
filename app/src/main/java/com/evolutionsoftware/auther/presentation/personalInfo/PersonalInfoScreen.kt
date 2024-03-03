package com.evolutionsoftware.auther.presentation.personalInfo

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
fun PersonalInfoScreen(navController: NavHostController, viewModel: PersonalInfoViewModel = getViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        OutlinedTextField(
            value = viewModel.state.firstName,
            onValueChange = { viewModel.state = viewModel.state.copy(firstName = it) },
            label = { Text("First Name") },
            modifier = Modifier.padding(16.dp)
        )
        OutlinedTextField(
            value = viewModel.state.name,
            onValueChange = { viewModel.state = viewModel.state.copy(name = it) },
            label = { Text("Last Name") },
            modifier = Modifier.padding(16.dp)
        )
        OutlinedTextField(
            value = viewModel.state.phoneNumber,
            onValueChange = { viewModel.state = viewModel.state.copy(phoneNumber = it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Phone Number") },
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                if (viewModel.state.name.isNotEmpty() && 
                    viewModel.state.firstName.isNotEmpty() && 
                    viewModel.state.phoneNumber.isNotEmpty()) {
                    viewModel.updateUserPersonalInfo()
                    navController.navigate(Routes.PIN)
                }
            },
            enabled = viewModel.state.name.isNotEmpty() &&
                    viewModel.state.firstName.isNotEmpty() &&
                    viewModel.state.phoneNumber.isNotEmpty(),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Continue")
        }
    }
}