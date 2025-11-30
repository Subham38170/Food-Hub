package com.example.foodhub.di

import com.example.foodhub.domain.repository.AuthRepository
import com.example.foodhub.domain.repository.ProductRepository
import com.example.foodhub.domain.use_cases.auth.LoginUseCase
import com.example.foodhub.domain.use_cases.auth.SignUpUseCase
import com.example.foodhub.domain.use_cases.product.GetCategoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideSignUpUsecase(
        authRepo: AuthRepository
    ): SignUpUseCase = SignUpUseCase(authRepo)


    @Provides
    @Singleton
    fun provideLoginUseCase(
        authRepo: AuthRepository
    ): LoginUseCase = LoginUseCase(authRepo)

    @Provides
    @Singleton
    fun provideGetCategoriesUseCase(
        productRepo: ProductRepository
    ): GetCategoriesUseCase = GetCategoriesUseCase(productRepo)
}