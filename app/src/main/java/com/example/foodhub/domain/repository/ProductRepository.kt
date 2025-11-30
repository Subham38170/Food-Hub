package com.example.foodhub.domain.repository

import com.example.foodhub.core.Result
import com.example.foodhub.domain.model.product.Category
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getCategories(): Flow<Result<List<Category>>>
}