package com.example.foodhub.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Routes : NavKey {

    @Serializable
    object SignInScreen : Routes

    @Serializable
    object SignUpScreen : Routes


    @Serializable
    object HomeScreen : Routes

    @Serializable
    object AuthScreen: Routes
}