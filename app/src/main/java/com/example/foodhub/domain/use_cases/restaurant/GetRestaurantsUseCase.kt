package com.example.foodhub.domain.use_cases.restaurant

import com.example.foodhub.domain.repository.RestaurantRepository
import javax.inject.Inject

class GetRestaurantsUseCase @Inject constructor(
    private val restaurantRepo: RestaurantRepository
) {
    suspend operator fun invoke() = restaurantRepo.getRestaurants()
}