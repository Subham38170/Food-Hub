package com.example.foodhub.data.mappers

import com.example.foodhub.data.model.product.CategoryDto
import com.example.foodhub.domain.model.product.Category

object CategoryMapper {
    fun toDto(category: Category): CategoryDto {
        return CategoryDto(
            id = category.id,
            name = category.name,
            imageUrl = category.imageUrl,
            createdAt = category.createdAt.toString()
        )
    }

    fun fromDto(categoryDto: CategoryDto): Category {
        return Category(
            id = categoryDto.id,
            name = categoryDto.name,
            imageUrl = categoryDto.imageUrl,
            createdAt = categoryDto.createdAt.toLongOrNull()?: 0L
        )
    }
}