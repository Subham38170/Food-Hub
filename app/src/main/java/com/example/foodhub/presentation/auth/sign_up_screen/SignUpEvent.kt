package com.example.foodhub.presentation.auth.sign_up_screen


//Event for handling the signup feature
sealed class SignUpEvent {

    data class onEmailChanged(val email: String) : SignUpEvent()

    data class onNameChanged(val name: String) : SignUpEvent()

    data class onPasswordChanged(val password: String) : SignUpEvent()

    object onSignUpClick : SignUpEvent()

    object onLoginClick : SignUpEvent()

    object onGoogleClick : SignUpEvent()

    object onFacebookClick : SignUpEvent()
}


