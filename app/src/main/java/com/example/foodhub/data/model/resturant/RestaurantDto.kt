package com.example.foodhub.data.model.resturant

data class RestaurantDto(
    val address: String ="",
    val categoryId: String? = null,
    val createdAt: String = "",
    val distance: Double = 0.0,
    val id: String?= null,
    val imageUrl: String? = null,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val name: String = "",
    val ownerId: String? = null
)