package com.example.foodhub.domain.use_cases.product

import com.example.foodhub.core.Result
import com.example.foodhub.domain.model.product.Category
import com.example.foodhub.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(): Flow<Result<List<Category>>> {
        return productRepository.getCategories()
    }

}