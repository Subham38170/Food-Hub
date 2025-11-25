package com.example.foodhub.domain.use_cases.auth

import com.example.foodhub.core.Result
import com.example.foodhub.domain.model.user.User
import com.example.foodhub.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepo: AuthRepository
) {
    operator fun invoke(
        email: String,
        password: String
    ): Flow<Result<User>> = authRepo.loginWithEmailAndPassword(email, password)
}