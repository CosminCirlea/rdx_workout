package com.evolutionsoftware.auther.presentation.termsOfService

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.koin.androidx.compose.getViewModel

@Composable
fun TermsScreen(navController: NavHostController,
                viewModel: TermsViewModel = getViewModel()
) {
    var isChecked by remember { mutableStateOf(viewModel.isChecked) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            "Terms of Service",
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color.White
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f),
                color = Color.White
            )
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                    viewModel.isChecked = it
                }
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { if (isChecked) navController.navigate("credentials") },
            enabled = isChecked,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(text = "Continue")
        }
    }
}