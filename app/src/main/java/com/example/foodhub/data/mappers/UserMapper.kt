package com.example.foodhub.data.mappers

import com.example.foodhub.data.model.user.UserDto
import com.example.foodhub.domain.model.user.User

object UserMapper {
    fun toDto(user: User): UserDto {
        return UserDto(
            uid = user.uid,
            name = user.name,
            email = user.email,
        )
    }

    fun fromDto(user: UserDto): User {
        return User(
            uid = user.uid,
            name = user.name,
            email = user.email,
        )
    }

}