package com.example.foodhub.presentation.auth.sign_in_screen

sealed class SignInEvent {

    data class onEmailChange(val email: String) : SignInEvent()

    data class onPasswordChange(val password: String) : SignInEvent()

    object onSignUpClick : SignInEvent()

    object onSignInClick : SignInEvent()

    object onGoogleClick : SignInEvent()

    object onFacebookClick : SignInEvent()

    object onForgotPasswordClick : SignInEvent()

}