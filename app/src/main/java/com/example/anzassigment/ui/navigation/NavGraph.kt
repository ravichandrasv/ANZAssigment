package com.example.anzassigment.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.anzassigment.ui.users.UserDetailScreen
import com.example.anzassigment.ui.users.UsersScreen
import com.example.anzassigment.ui.users.viewmodel.UsersViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "users") {
        composable("users") {
            val vm: UsersViewModel = hiltViewModel()
            UsersScreen(viewModel = vm, onUserClick = { id -> navController.navigate("user/$id") })
        }
        composable(
            "user/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.StringType })
        ) { backStack ->
            val id = backStack.arguments?.getString("userId") ?: ""
            UserDetailScreen(userId = id)
        }
    }
}
