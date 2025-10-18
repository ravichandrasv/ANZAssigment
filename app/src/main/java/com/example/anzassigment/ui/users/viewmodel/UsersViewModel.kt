package com.example.anzassigment.ui.users.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anzassigment.domain.UserRepository
import com.example.anzassigment.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val repo: UserRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(UsersUiState())
    val uiState: StateFlow<UsersUiState> = _uiState.asStateFlow()

    init { loadUsers() }

    fun loadUsers() = viewModelScope.launch {
        _uiState.update { it.copy(isLoading = true, error = null) }
        try {
            val users = repo.fetchUsers()
            _uiState.update { it.copy(isLoading = false, users = users) }
        } catch (e: Exception) {
            _uiState.update { it.copy(isLoading = false, error = e.message ?: "Unknown") }
        }
    }
}

data class UsersUiState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String? = null
)
