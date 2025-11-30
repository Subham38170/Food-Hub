package com.example.foodhub.presentation.auth.sign_in_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodhub.core.Result
import com.example.foodhub.domain.use_cases.auth.LoginUseCase
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
class SignInViewModel @Inject constructor(
    private val signInUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignInState())
    val uiState = _uiState.asStateFlow()

    private val _uiEffect = MutableSharedFlow<SignInEffect>()
    val uiEffect = _uiEffect.asSharedFlow()


    fun onEvent(
        event: SignInEvent
    ) {
        when (event) {
            is SignInEvent.onEmailChange -> {
                _uiState.update {
                    it.copy(
                        email = event.email
                    )
                }
            }

            is SignInEvent.onFacebookClick -> {

            }

            is SignInEvent.onForgotPasswordClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    _uiEffect.emit(SignInEffect.navigateToForgetPasswordScreen)
                }
            }

            is SignInEvent.onGoogleClick -> {

            }

            is SignInEvent.onPasswordChange -> {
                _uiState.update {
                    it.copy(
                        password = event.password
                    )
                }
            }

            is SignInEvent.onSignInClick -> {
                signIn()
            }

            is SignInEvent.onSignUpClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    _uiEffect.emit(SignInEffect.navigateToSignUpScreen)
                }
            }
        }

    }

    private fun signIn() {
        viewModelScope.launch(Dispatchers.IO) {
            signInUseCase(uiState.value.email, uiState.value.password)
                .collect { result ->
                    when (result) {
                        is Result.Error -> {
                            _uiState.update {
                                it.copy(
                                    isLoading = false
                                )
                            }
                            Log.d("CHECK", result.message.toString())

                            _uiEffect.emit(SignInEffect.showSnackbar(result.message.toString()))
                        }

                        is Result.Loading -> {
                            _uiState.update {
                                it.copy(
                                    isLoading = true
                                )
                            }
                            Log.d("CHECK", "Loading")
                        }

                        is Result.Success -> {
                            _uiState.update {
                                it.copy(
                                    isLoading = false
                                )
                            }
                            Log.d("CHECK", "Signed In Sucesfully")
                            _uiEffect.emit(SignInEffect.showToast("Signed In Sucessfully"))

                            _uiEffect.emit(SignInEffect.navigateToHomeScreen)

                        }
                    }
                }
        }
    }
}