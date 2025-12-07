package com.example.foodhub.data.repository

import android.util.Log
import com.example.foodhub.core.Result
import com.example.foodhub.core.constants.FirebaseConstants
import com.example.foodhub.data.mappers.RestaurantMapper
import com.example.foodhub.data.model.resturant.RestaurantDto
import com.example.foodhub.domain.model.resturant.Restaurant
import com.example.foodhub.domain.repository.RestaurantRepository
import com.google.firebase.firestore.FirebaseFirestore
import jakarta.inject.Inject
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.util.UUID

class RestaurantRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : RestaurantRepository {
    override fun getRestaurants(): Flow<Result<List<Restaurant>>> {

        return callbackFlow {
            trySend(Result.Loading)

            val listener = firestore.collection(FirebaseConstants.RESTAURANTS)
                .addSnapshotListener { snapshot, error ->
                    error?.let { e ->
                        trySend(Result.Error(e.message))
                        return@addSnapshotListener
                    }

                    snapshot?.let { result ->
                        val data = result.documents
                            .mapNotNull { doc -> doc.toObject(RestaurantDto::class.java) }
                            .map { dto -> RestaurantMapper.fromDto(dto) }
                        trySend(Result.Success(data))
                    }

                }
            awaitClose { listener.remove() }
        }
    }
}