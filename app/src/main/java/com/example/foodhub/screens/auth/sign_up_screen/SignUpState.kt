package com.example.foodhub.screens.auth.sign_up_screen


//Stores the state of the Sign Up Screen
data class SignUpState(
    val email: String = "",
    val name: String = "",
    val password: String = "",
    val isLoading: Boolean = false
)