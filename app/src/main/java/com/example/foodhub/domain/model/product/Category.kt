package com.example.foodhub.domain.model.product

data class Category(
    val id: String? = null,
    val imageUrl: String? = null,
    val name: String = "",
    val createdAt: Long = 0L
)