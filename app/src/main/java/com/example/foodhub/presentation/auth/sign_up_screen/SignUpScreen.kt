package com.example.foodhub.presentation.auth.sign_up_screen

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import kotlinx.coroutines.flow.collectLatest

/***
 * Sign Up screen contains 3 options for sign up process
 * 1, Sign up using fullname, email and password
 * 2. Using facebook account
 * 3. Using Google account
 */


@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel,
    navigate: (Routes) -> Unit
) {
    //Hosts snackbar on screen if any effect collected
    val snackbarHostState = remember { SnackbarHostState() }
    //Context
    val context = LocalContext.current
    //State of this screen collected from viewmoderl
    val state by viewModel.uiState.collectAsState()


    //For scrollable screen
    val scrollState = rememberScrollState()
    //Collects effects recieved from viewmodel which includes toast,snack bar for error , navigations for different screens
    LaunchedEffect(true) {
        viewModel.uiEffect.collectLatest { effect ->
            when (effect) {
                is SignUpEffect.NavigateToFacebook -> {

                }

                is SignUpEffect.NavigateToGoogle -> {
                }

                is SignUpEffect.NavigateToSignIn -> {
                    navigate(Routes.SignInScreen)
                }

                is SignUpEffect.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(message = effect.message)
                }

                is SignUpEffect.ShowToast -> {
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

        //Background Image
        Image(
            painter = painterResource(id = R.drawable.sign_up_screen_background),
            contentDescription = "Back ground image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
        //Main container contains other sub containers and content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = Constants.TopAppScreenPadding)
                .padding(horizontal = 20.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            //Title : Sign Up
            Text(
                text = "Sign Up",
                color = Color.Black,
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))
            //Customized text field to collect user name
            CustomizedOutlinedTextField(
                value = state.name,
                onValueChange = {
                    viewModel.onEvent(SignUpEvent.onNameChanged(it))
                },
                placeHolder = "Enter your full name",
                label = "Full name",
                modifier = Modifier
                    .fillMaxWidth()
            )
            //Customized text field to collect user email
            CustomizedOutlinedTextField(
                value = state.email,
                onValueChange = {
                    viewModel.onEvent(SignUpEvent.onEmailChanged(it))
                },
                placeHolder = "Your e-mail",
                label = "Email",
                modifier = Modifier
                    .fillMaxWidth(),
                keyboardType = KeyboardType.Email
            )
            //Customized text field to collect password
            CustomizedPasswordTextField(
                value = state.password,
                onValueChange = {
                    viewModel.onEvent(SignUpEvent.onPasswordChanged(it))
                },
                modifier = Modifier
                    .fillMaxWidth(),
                placeHolder = "Password",
                label = "Password",
                supportingText = state.passwordValidatorMessage
            )
            //Customized Sign up button
            CustomizedElevatedButton(
                text = "Sign Up",
                onClick = {
                    if (!state.isLoading) viewModel.onEvent(SignUpEvent.onSignUpClick)
                },
                modifier = Modifier
                    .width(240.dp)
                    .padding(top = 20.dp),
                loading = state.isLoading
            )
            //Login button to navigate to login screen
            CustomizedTextButton(
                onClick = {

                    viewModel.onEvent(SignUpEvent.onLoginClick)
                },
                text = "Login",
                prefixText = "Already have an account?",
                prefixTextColor = Color.Black
            )
            //Sub container contains facebook and google sign Up buttons
            Column {
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
                //Button with Facebook and Google symbol for Sign Up using facebook or google  account
                FGButton(
                    onGoogleButtonClick = {

                    },
                    onFaceBookButtonClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 28.dp)
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
