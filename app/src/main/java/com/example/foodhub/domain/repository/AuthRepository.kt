package com.example.foodhub.domain.repository

import com.example.foodhub.core.Result
import com.example.foodhub.domain.model.user.User
import kotlinx.coroutines.flow.Flow


interface AuthRepository {


    fun loginWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<Result<User>>

    fun signUpWithEmailAndPassword(
        fullName: String,
        email: String,
        password: String
    ): Flow<Result<User>>
}