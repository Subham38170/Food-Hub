package com.example.foodhub.presentation.home

import androidx.compose.foundation.layout.Box
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp)
    ) {

        LazyRow(
            Modifier
                .fillMaxWidth()
        ) {
            items(state.categoryList) {
                CategoryItem(
                    category = it,
                    onClick = {}
                )
            }
        }
    }
}