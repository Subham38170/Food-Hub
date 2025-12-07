package com.example.foodhub.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodhub.core.Result
import com.example.foodhub.domain.use_cases.product.GetCategoriesUseCase
import com.example.foodhub.domain.use_cases.restaurant.GetRestaurantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getRestaurantsUsecase: GetRestaurantsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeScreenState>(HomeScreenState())
    val uiState = _uiState.asStateFlow()

    private val _uiEffect = MutableSharedFlow<HomeScreenEffect>()
    val uiEffect = _uiEffect.asSharedFlow()

    init {

        getCategories()
        getPopularRestaurants()
    }

    private fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            getCategoriesUseCase().collect { result ->
                when (result) {
                    is Result.Error -> {
                        _uiEffect.emit(HomeScreenEffect.showSnackbar(result.message.toString()))
                        _uiState.update {
                            it.copy(
                                isCategoriesLoading = false
                            )
                        }
                        Log.d("CATEGORY", "ErrorL ${result.message}")
                    }

                    is Result.Loading -> {
                        _uiState.update {
                            it.copy(
                                isCategoriesLoading = true
                            )
                        }
                        Log.d("CATEGORY", "Loading")

                    }

                    is Result.Success -> {
                        _uiState.update {
                            it.copy(
                                isCategoriesLoading = false,
                                categoryList = result.data
                            )
                        }
                        Log.d("CATEGORY", "ErrorL ${result.data.toString()}")

                    }
                }
            }

        }
    }

    private fun getPopularRestaurants() {
        viewModelScope.launch(Dispatchers.IO) {
            getRestaurantsUsecase().collect { result ->
                when (result) {
                    is Result.Error -> {
                        _uiState.update {
                            it.copy(
                                isRestaurantsLoading = false
                            )
                        }
                        Log.d("RESTAURANT", "ErrorL ${result.message}")
                        _uiEffect.emit(HomeScreenEffect.showSnackbar(result.message.toString()))
                    }

                    is Result.Loading -> {
                        _uiState.update {
                            it.copy(
                                isRestaurantsLoading = true
                            )
                        }
                        Log.d("RESTAURANT", "Loading")
                    }

                    is Result.Success -> {
                        _uiState.update {
                            it.copy(
                                isRestaurantsLoading = false,
                                restaurantsList = result.data
                            )
                        }
                        Log.d("RESTAURANT", "Sucess ${result.data.toString()}")
                    }
                }
            }
        }
    }
}