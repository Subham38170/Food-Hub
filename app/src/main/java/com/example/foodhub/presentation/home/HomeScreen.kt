package com.example.foodhub.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodhub.presentation.components.CategoryItem
import com.example.foodhub.presentation.components.RestaurantItem
import com.example.foodhub.presentation.navigation.Routes
import kotlinx.coroutines.flow.collectLatest


//Home screen
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navigate: (Routes) -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collectLatest { effect ->
            when (effect) {
                is HomeScreenEffect.showSnackbar -> {

                }

                is HomeScreenEffect.showToast -> {

                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp)
    ) {

        LazyRow(
            Modifier
                .fillMaxWidth(),
        ) {
            items(state.categoryList, { it.id.toString() }) {
                CategoryItem(
                    category = it,
                    onClick = {}
                )
            }
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),

            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.restaurantsList, { it.id.toString() }) {
                RestaurantItem(
                    restaurant = it,
                    onClick = {}
                )
            }
        }
    }
}