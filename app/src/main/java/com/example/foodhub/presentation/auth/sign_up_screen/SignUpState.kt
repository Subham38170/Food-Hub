package com.example.foodhub.presentation.auth.sign_up_screen


//Stores the state of the Sign Up Screen
data class SignUpState(
    val email: String = "",
    val name: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val passwordValidatorMessage: String? = null
)