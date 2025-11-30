package com.example.foodhub.di

import com.example.foodhub.data.repository.AuthRepositoryImpl
import com.example.foodhub.data.repository.ProductRepositoryImpl
import com.example.foodhub.domain.repository.AuthRepository
import com.example.foodhub.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun provideProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository
}
