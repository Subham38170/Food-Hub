package com.example.foodhub.screens.auth.sign_up_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodhub.R
import com.example.foodhub.screens.Constants
import com.example.foodhub.screens.components.CustomizedElevatedButton
import com.example.foodhub.screens.components.CustomizedOutlinedTextField
import com.example.foodhub.screens.components.CustomizedPasswordTextField
import com.example.foodhub.screens.components.CustomizedTextButton
import com.example.foodhub.screens.components.FGButton
import com.example.foodhub.screens.components.TextWithHorizontalDivider

/***
 * Sign Up screen contains 3 options for sign up process
 * 1, Sign up using fullname, email and password
 * 2. Using facebook account
 * 3. Using Google account
 */


@Composable
fun SignUpScreen() {

    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                text = "Sign Up",
                color = Color.Black,
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomizedOutlinedTextField(
                value = fullName,
                onValueChange = {
                    fullName = it
                },
                placeHolder = "Enter your full name",
                label = "Full name",
                modifier = Modifier
                    .fillMaxWidth()
            )
            CustomizedOutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                placeHolder = "Your e-mail",
                label = "Email",
                modifier = Modifier
                    .fillMaxWidth(),
                keyboardType = KeyboardType.Email
            )
            CustomizedPasswordTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth(),
                placeHolder = "Password",
                label = "Password"
            )
            CustomizedElevatedButton(
                text = "Sign Up",
                onClick = {

                },
                modifier = Modifier
                    .width(240.dp)
                    .padding(top = 20.dp)
            )
            CustomizedTextButton(
                onClick = {},
                text = "Login",
                prefixText = "Already have an account?",
                prefixTextColor = Color.Black
            )
            Column {
                TextWithHorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Sign up with",
                    color = Color.Black
                )
                Spacer(modifier = Modifier
                    .height(4.dp)
                )
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

    }
}
