package com.example.foodhub.presentation.auth.sign_in_screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodhub.R
import com.example.foodhub.presentation.Constants
import com.example.foodhub.presentation.components.CustomizedElevatedButton
import com.example.foodhub.presentation.components.CustomizedOutlinedTextField
import com.example.foodhub.presentation.components.CustomizedPasswordTextField
import com.example.foodhub.presentation.components.CustomizedTextButton
import com.example.foodhub.presentation.components.FGButton
import com.example.foodhub.presentation.components.TextWithHorizontalDivider
import com.example.foodhub.presentation.navigation.Routes
import kotlinx.coroutines.launch


@Composable
fun SignInScreen(
    viewModel: SignInViewModel,
    navigate: (Routes) -> Unit
) {
    //Snackbar host State
    val snackbarHostState = remember { SnackbarHostState() }

    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->

            when (effect) {
                is SignInEffect.navigateToForgetPasswordScreen -> {

                }

                is SignInEffect.navigateToHomeScreen -> {
                    navigate(Routes.HomeScreen)
                }

                is SignInEffect.navigateToSignUpScreen -> {
                    navigate(Routes.SignUpScreen)
                }

                is SignInEffect.showSnackbar -> {
                    scope.launch {
                        snackbarHostState.showSnackbar(effect.message)
                    }

                }

                is SignInEffect.showToast -> {
                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    //Root container for Sign Up Screen
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.sign_up_screen_background),
            contentDescription = "Back ground image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = Constants.TopAppScreenPadding)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Login",
                color = Color.Black,
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .fillMaxWidth()
            )

            CustomizedOutlinedTextField(
                value = state.email,
                onValueChange = {
                    viewModel.onEvent(SignInEvent.onEmailChange(it))
                },
                placeHolder = "Your e-mail",
                label = "Email",
                modifier = Modifier
                    .fillMaxWidth(),
                keyboardType = KeyboardType.Email
            )
            CustomizedPasswordTextField(
                value = state.password,
                onValueChange = {
                    viewModel.onEvent(SignInEvent.onPasswordChange(it))
                },
                modifier = Modifier
                    .fillMaxWidth(),
                placeHolder = "Password",
                label = "Password"
            )
            CustomizedTextButton(
                text = "Forgot password?",
                onClick = {
                    viewModel.onEvent(SignInEvent.onForgotPasswordClick)
                }
            )
            CustomizedElevatedButton(
                text = "Login",
                onClick = {
                    viewModel.onEvent(SignInEvent.onSignInClick)
                },
                modifier = Modifier
                    .width(240.dp),
                loading = state.isLoading
            )
            CustomizedTextButton(
                onClick = {
                    viewModel.onEvent(SignInEvent.onSignUpClick)
                },
                enabled = !state.isLoading,

                text = "Sign Up",
                prefixText = "Don't have an account?",
                prefixTextColor = Color.Black
            )
            Column(
                modifier = Modifier
                    .padding(bottom = 40.dp)
            ) {
                TextWithHorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Sign up with",
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .height(4.dp)
                )
                FGButton(
                    onGoogleButtonClick = {
                        viewModel.onEvent(SignInEvent.onGoogleClick)
                    },
                    onFaceBookButtonClick = {
                        viewModel.onEvent(SignInEvent.onFacebookClick)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

        }
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )

    }

}