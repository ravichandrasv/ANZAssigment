package com.example.anzassigment.repo

import com.example.anzassigment.data.User
import com.example.anzassigment.data.UserApi
import com.example.anzassigment.domain.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: UserApi) : UserRepository {
    override suspend fun fetchUsers(): List<User> = api.getUsers().map { it.toDomain() }

    override suspend fun getUserById(id: String): User? =
        fetchUsers().firstOrNull { it.id == id }
}
