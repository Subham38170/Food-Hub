package com.example.foodhub.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.foodhub.presentation.auth.AuthScreen
import com.example.foodhub.presentation.auth.sign_in_screen.SignInScreen
import com.example.foodhub.presentation.auth.sign_in_screen.SignInViewModel
import com.example.foodhub.presentation.auth.sign_up_screen.SignUpScreen
import com.example.foodhub.presentation.auth.sign_up_screen.SignUpViewModel
import com.example.foodhub.presentation.home.HomeScreen
import com.example.foodhub.presentation.home.HomeViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavGraph() {
    val auth = FirebaseAuth.getInstance()
    val backStack =
        rememberNavBackStack(if (auth.uid.isNullOrBlank()) Routes.AuthScreen else Routes.HomeScreen)


    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Routes.AuthScreen> {
                AuthScreen(
                    navigateToSignInScreen = {

                        if (backStack.lastOrNull() != Routes.SignInScreen) backStack.add(Routes.SignInScreen)

                    },
                    navigateToSignUpScreen = {
                        if (backStack.lastOrNull() != Routes.SignUpScreen) backStack.add(Routes.SignUpScreen)

                    }
                )
            }
            entry<Routes.SignInScreen> {
                SignInScreen(
                    viewModel = hiltViewModel<SignInViewModel>(),
                    navigate = { routes ->
                        when (routes) {
                            is Routes.HomeScreen -> {
                                backStack.apply {
                                    removeLastOrNull()
                                    add(Routes.HomeScreen)
                                }
                            }

                            is Routes.SignUpScreen -> {
                                backStack.apply {
                                    removeLastOrNull()
                                    add(Routes.SignUpScreen)
                                }
                            }

                            else -> {}
                        }
                    }
                )
            }
            entry<Routes.HomeScreen> {
                val viewModel = hiltViewModel<HomeViewModel>()
                HomeScreen(
                    viewModel = viewModel,
                    navigate = { route ->
                        when (route) {
                            else -> {}
                        }
                    }
                )
            }
            entry<Routes.SignUpScreen> {
                val viewModel = hiltViewModel<SignUpViewModel>()
                SignUpScreen(
                    viewModel = viewModel,
                    navigate = { routes ->
                        when (routes) {
                            is Routes.SignInScreen -> {
                                backStack.apply {
                                    removeLastOrNull()
                                    add(Routes.SignInScreen)
                                }
                            }

                            else -> {

                            }
                        }
                    }
                )
            }
        }
    )
}