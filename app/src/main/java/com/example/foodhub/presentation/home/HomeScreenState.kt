package com.example.foodhub.presentation.home

import com.example.foodhub.domain.model.product.Category
import com.example.foodhub.domain.model.resturant.Restaurant

data class HomeScreenState(
    val isLoading: Boolean = false,
    val categoryList: List<Category> = emptyList(),
    val isCategoriesLoading: Boolean = false,
    val restaurantsList: List<Restaurant> = emptyList(),
    val isRestaurantsLoading: Boolean = false
)