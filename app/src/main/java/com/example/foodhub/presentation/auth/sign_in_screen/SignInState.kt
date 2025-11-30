package com.example.foodhub.presentation.auth.sign_in_screen

data class SignInState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false
)