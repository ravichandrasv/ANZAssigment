package com.example.anzassigment.ui.users

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.anzassigment.ui.users.viewmodel.UsersViewModel

@Composable
fun UsersScreen(viewModel: UsersViewModel, onUserClick: (String) -> Unit) {
    val state by viewModel.uiState.collectAsState()

    when {
        state.isLoading -> Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

        state.error != null -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Error: ${state.error}")
        }

        else -> LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.users) { user ->
                ListItem(
                    headlineContent = { Text(user.name) },
                    supportingContent = { Text(user.email) },
                    leadingContent = {
                        Image(
                            painter = rememberAsyncImagePainter(user.photo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(56.dp)
                                .padding(4.dp)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onUserClick(user.id) }
                )
            }
        }
    }
}
