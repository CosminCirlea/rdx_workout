package com.evolutionsoftware.auther.presentation.credentials

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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.evolutionsoftware.auther.domain.Routes
import org.koin.androidx.compose.getViewModel

@Composable
fun CredentialsScreen(navController: NavHostController, viewModel: CredentialsViewModel = getViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        OutlinedTextField(
            value = viewModel.state.email ?: "",
            onValueChange = { viewModel.state = viewModel.state.copy(email = it) },
            label = { Text(text = "Email")},
            modifier = Modifier.padding(16.dp)
        )
        OutlinedTextField(
            value = viewModel.state.password ?: "",
            onValueChange = { viewModel.state = viewModel.state.copy(password = it) },
            label = { Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                viewModel.updateUserCredentials()
                navController.navigate(Routes.PERSONAL_INFO)
            },
            enabled = credentialsValid(viewModel.state.email, viewModel.state.password),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Continue")
        }
    }
}

private fun credentialsValid(email: String?, password: String?): Boolean {
    return validEmail(email) && validPassword(password)
}

private fun validEmail(email: String?): Boolean {
    return email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

private fun validPassword(password: String?): Boolean {
    val passwordRegex = "^(?=.*[A-Z])(?=.*\\d).{6,}$".toRegex()
    return password != null && passwordRegex.matches(password)
}