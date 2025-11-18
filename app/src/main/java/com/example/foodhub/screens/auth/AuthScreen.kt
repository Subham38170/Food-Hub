package com.example.foodhub.screens.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodhub.R


/**
 * AuthScreen - Displays the authentication landing page.
 * Shows the background image and acts as an entry point for login/register navigation.
 */

@Composable
fun AuthScreen() {

    //Background color -> With gradient over the background image
    val brush = Brush.verticalGradient(
        listOf(
            Color.Transparent, Color.Black
        )
    )


    //Root container of the screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        //Background image acts as landing page
        Image(
            painter = painterResource(id = R.drawable.auth_screen_background),
            contentDescription = "Auth screen background image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Fit
        )
        //Welcome text contents (e.g. Welcome to Food Hub with description)
        FoodHubContents(
            brush = brush
        )

        //Sub container contains Sign In,Facebook and email buttons.
        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(20.dp)

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    color = Color.White, modifier = Modifier.weight(0.3f)
                )
                Text(
                    text = "sign in with",
                    color = Color.White,
                    modifier = Modifier.weight(0.4f),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                HorizontalDivider(color = Color.White, modifier = Modifier.weight(0.3f))
            }
            //Register with Facebook or Google Account
            FGButton(
                onFaceBookButtonClick = {},
                onGoogleButtonClick = {}
            )

            //Register with email or phone
            EmailPhoneButton(
                onClick = {}
            )

            //Sign In Button for those who have already account
            AccountSignIn(
                onClick = {}
            )
        }
    }
}

//Customized Button for both Google and Facebook
@Composable
private fun FGButton(
    onFaceBookButtonClick: () -> Unit,
    onGoogleButtonClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(
            top = 28.dp,
            bottom = 36.dp
        ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            modifier = Modifier.weight(0.45f)
                .height(56.dp)
                .background(Color.White, RoundedCornerShape(28.dp)).padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = "Facebook Icon",
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = "Facebook",
                color = Color.Black,
                fontSize = 20.sp
            )
        }
        Box(
            modifier = Modifier
                .weight(0.1f)
        )

        Row(
            modifier = Modifier.weight(0.45f)
                .height(56.dp)
                .background(Color.White, RoundedCornerShape(28.dp)).padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "Google Icon",
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = "Google",
                color = Color.Black,
                fontSize = 20.sp
            )
        }
    }

}

//Section contains Already Have an Account : SignIn
@Composable
private fun AccountSignIn(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Already have an account? ", color = Color.White, fontSize = 16.sp
        )
        TextButton(
            onClick = onClick, contentPadding = PaddingValues(0.dp)
        ) {
            Text(

                text = "Sign In",
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

//Customized Button for Email or Phone No.
@Composable
private fun EmailPhoneButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Gray.copy(alpha = 0.6f)
        ),
        border = BorderStroke(1.dp, Color.White),
        contentPadding = PaddingValues(12.dp)
    ) {
        Text(
            text = "Start with email or phone",
            fontSize = 20.sp,
            fontWeight = FontWeight.Light
        )
    }

}


@Composable
private fun FoodHubContents(
    brush: Brush
) {

    //Root container for welcome and description
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush)
            .padding(top = 120.dp)
            .padding(20.dp)
    ) {
        //Welcome with color black
        Text(
            text = stringResource(id = R.string.welcome),
            color = Color.Black,
            modifier = Modifier,
            fontSize = 52.sp,
            fontWeight = FontWeight.ExtraBold
        )
        //Food Hub with color orange
        Text(
            text = stringResource(id = R.string.food_hub),
            color = colorResource(id = R.color.orange),
            modifier = Modifier,
            fontSize = 52.sp,
            fontWeight = FontWeight.ExtraBold
        )
        //Description with color black
        Text(
            text = stringResource(id = R.string.desc),
            color = Color.Black,
            modifier = Modifier.padding(top = 16.dp),
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen()
}