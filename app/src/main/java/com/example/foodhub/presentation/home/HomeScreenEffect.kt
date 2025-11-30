package com.example.foodhub.presentation.home

sealed class HomeScreenEffect {
    data class showSnackbar(val message: String) : HomeScreenEffect()

    data class showToast(val message: String) : HomeScreenEffect()


}