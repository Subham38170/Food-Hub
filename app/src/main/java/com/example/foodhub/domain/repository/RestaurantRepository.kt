package com.example.foodhub.domain.repository

import com.example.foodhub.core.Result
import com.example.foodhub.domain.model.resturant.Restaurant
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {

     fun getRestaurants(): Flow<Result<List<Restaurant>>>
}