package com.example.foodhub.presentation.auth.sign_up_screen


//Handles Effects for SignUp Screen
sealed class SignUpEffect {

    data class ShowToast(val message: String ): SignUpEffect()

    object NavigateToGoogle: SignUpEffect()

    object NavigateToFacebook: SignUpEffect()

    object NavigateToSignIn: SignUpEffect()

    data class ShowSnackbar(val message: String): SignUpEffect()
}