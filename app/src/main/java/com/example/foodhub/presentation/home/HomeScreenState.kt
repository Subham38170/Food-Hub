package com.example.foodhub.presentation.home

import com.example.foodhub.domain.model.product.Category

data class HomeScreenState(
    val isLoading: Boolean = false,
    val categoryList: List<Category> = emptyList(),
    val isCategoriesLoading: Boolean = false
)