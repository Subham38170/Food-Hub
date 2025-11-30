package com.example.foodhub.presentation.auth.sign_in_screen

sealed class SignInEffect {

    object navigateToSignUpScreen : SignInEffect()

    object navigateToForgetPasswordScreen : SignInEffect()

    object navigateToHomeScreen: SignInEffect()

    data class showSnackbar(val message: String) : SignInEffect()

    data class showToast(val message: String) : SignInEffect()
}