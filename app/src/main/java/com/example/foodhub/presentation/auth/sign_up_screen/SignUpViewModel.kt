package com.example.foodhub.presentation.auth.sign_up_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodhub.core.Result
import com.example.foodhub.domain.use_cases.auth.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


//Viewmodel for SignUp Screen
@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {


    //State to handle UI components
    private val _uiState = MutableStateFlow(SignUpState())
    val uiState = _uiState.asStateFlow()


    //State to handle ui effects to emit a flow for different actions like navigate to homescreen,show snackbar, toast etc
    private val _uiEffect = MutableSharedFlow<SignUpEffect>()
    val uiEffect = _uiEffect.asSharedFlow()


    //If any event occurs in screen this function observes those event to make update and effect
    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.onEmailChanged -> {
                _uiState.update {
                    it.copy(
                        email = event.email
                    )
                }
            }

            is SignUpEvent.onFacebookClick -> {

            }

            is SignUpEvent.onGoogleClick -> {

            }

            is SignUpEvent.onLoginClick -> {

            }

            is SignUpEvent.onNameChanged -> {
                _uiState.update {
                    it.copy(
                        name = event.name
                    )
                }
            }

            is SignUpEvent.onPasswordChanged -> {
                _uiState.update {
                    it.copy(
                        password = event.password,
                        passwordValidatorMessage = passwordValidator(event.password)
                    )
                }
            }

            is SignUpEvent.onSignUpClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    _uiState.update { it.copy(isLoading = true) }
                    signUpUseCase(
                        uiState.value.name, uiState.value.email, uiState.value.password
                    ).collect { result ->
                        when (result) {
                            is Result.Error -> {
                                _uiState.update {
                                    it.copy(
                                        isLoading = false
                                    )
                                }

                                _uiEffect.emit(SignUpEffect.ShowSnackbar(result.message.toString()))
                            }

                            is Result.Loading -> {
                                _uiState.update {
                                    it.copy(
                                        isLoading = true
                                    )
                                }
                            }

                            is Result.Success<*> -> {
                                _uiState.update {
                                    it.copy(
                                        isLoading = false

                                    )
                                }
                                _uiEffect.emit(SignUpEffect.ShowSnackbar("Signed up Sucessfully"))
                            }
                        }
                    }
                }
            }

        }
    }
    //Password validator

    private fun passwordValidator(
        password: String
    )

            : String
    ? = when {
        password.length < 6 -> "Password must be at least 6 characters long"
        !password.any { it.isUpperCase() } -> "Password must contain at least one uppercase letter"
        !password.any { it.isLowerCase() } -> "Password must contain at least one lowercase letter"
        !password.any { it.isDigit() } -> "Password must contain at least one digit"
        !password.any { !it.isLetterOrDigit() } -> "Password must contain one special case character"
        else -> null
    }
}

