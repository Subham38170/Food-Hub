package com.example.foodhub.screens.auth.sign_up_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
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
                        password = event.password
                    )
                }
            }

            is SignUpEvent.onSignUpClick -> {
                viewModelScope.launch {
                    _uiEffect.emit(SignUpEffect.ShowSnackbar("Signed up sucessfully"))
                }
            }
        }
    }


}