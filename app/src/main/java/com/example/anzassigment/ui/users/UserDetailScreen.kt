package com.example.anzassigment.ui.users

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.anzassigment.ui.users.viewmodel.UserDetailViewModel

@Composable
fun UserDetailScreen(
    userId: String,
    viewModel: UserDetailViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    LaunchedEffect(userId) { viewModel.loadUser(userId) }

    when {
        state.isLoading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

        state.user != null -> {
            val user = state.user
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(user?.photo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .padding(8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Name: ${user?.name}")
                Text(text = "Email: ${user?.email}")
                Text(text = "Company: ${user?.company}")
                Text(text = "Username: ${user?.username}")
                Text(text = "Phone: ${user?.phone}")
                Text(
                    text = "Address: ${user?.address}, ${user?.state}, ${user?.country} - ${user?.zip}"
                )
            }
        }

        state.error != null -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Error: ${state.error}")
        }

        else -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("User not found")
        }
    }
}
