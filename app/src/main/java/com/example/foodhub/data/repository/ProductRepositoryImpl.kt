package com.example.foodhub.data.repository

import android.util.Log
import com.example.foodhub.core.Result
import com.example.foodhub.core.constants.FirebaseConstants
import com.example.foodhub.data.mappers.CategoryMapper
import com.example.foodhub.data.model.product.CategoryDto
import com.example.foodhub.domain.model.product.Category
import com.example.foodhub.domain.repository.ProductRepository
import com.google.firebase.firestore.FirebaseFirestore
import jakarta.inject.Inject
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class ProductRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : ProductRepository {
    override suspend fun getCategories(): Flow<Result<List<Category>>> {
        return callbackFlow {
            trySend(Result.Loading)
            val listener = firestore.collection(FirebaseConstants.CATEGORIES)
                .addSnapshotListener { snapshot, error ->
                    error?.let {
                        Log.d("CATEGORY", it.message.toString())
                        trySend(Result.Error(it.message))
                        return@addSnapshotListener
                    }
                    snapshot?.let { snapshots ->

                        val categories = snapshots.documents
                            .mapNotNull { it.toObject(CategoryDto::class.java) }
                            .map { CategoryMapper.fromDto(it) }
                        trySend(Result.Success(categories))

                    }

                }
            awaitClose {
                listener.remove()
            }
        }

    }
}