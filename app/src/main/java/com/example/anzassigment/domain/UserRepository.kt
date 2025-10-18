package com.example.anzassigment.domain

import com.example.anzassigment.data.User

interface UserRepository {
    suspend fun fetchUsers(): List<User>
    suspend fun getUserById(id: String): User?
}
