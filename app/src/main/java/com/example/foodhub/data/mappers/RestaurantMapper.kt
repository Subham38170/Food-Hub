package com.example.foodhub.data.mappers

import com.example.foodhub.data.model.resturant.RestaurantDto
import com.example.foodhub.domain.model.resturant.Restaurant

object RestaurantMapper {


    fun fromDto(resturant: RestaurantDto): Restaurant {
        return Restaurant(
            address = resturant.address,
            categoryId = resturant.categoryId,
            createdAt = resturant.createdAt,
            distance = resturant.distance,
            id = resturant.id,
            imageUrl = resturant.imageUrl,
            latitude = resturant.latitude,
            longitude = resturant.longitude,
            name = resturant.name,
            ownerId = resturant.ownerId
        )
    }

    fun toDto(restaurant: Restaurant): RestaurantDto {
        return RestaurantDto(
            address = restaurant.address,
            categoryId = restaurant.categoryId,
            createdAt = restaurant.createdAt,
            distance = restaurant.distance,
            id = restaurant.id,
            imageUrl = restaurant.imageUrl,
            latitude = restaurant.latitude,
            longitude = restaurant.longitude,
            name = restaurant.name,
            ownerId = restaurant.ownerId
        )
    }


}