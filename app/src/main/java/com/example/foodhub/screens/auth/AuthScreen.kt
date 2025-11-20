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
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodhub.R
import com.example.foodhub.screens.Constants
import com.example.foodhub.screens.components.CustomizedTextButton
import com.example.foodhub.screens.components.FGButton
import com.example.foodhub.screens.components.TextWithHorizontalDivider
import com.example.foodhub.screens.ui.theme.Orange


/**
 * AuthScreen - Displays the authentication landing page.
 * Shows the background image and acts as an entry point for login/register navigation.
 */

@Composable
fun AuthScreen() {

    //Background color -> With gradient over the background image
    val brush = Brush.verticalGradient(
        listOf(
            Color.Transparent, Color.Black.copy(alpha = 0.9f)
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
            contentScale = ContentScale.FillBounds
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

            TextWithHorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "sign in with"
            )
            //Register with Facebook or Google Account
            FGButton(
                onFaceBookButtonClick = {},
                onGoogleButtonClick = {},
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 32.dp)
            )

            //Register with email or phone
            EmailPhoneButton(
                onClick = {}
            )

            //Sign In Button for those who have already account
            CustomizedTextButton(
                text = "Sign In",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {},
                prefixText = "Already have an account?"
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
            .padding(top = Constants.TopAppScreenPadding)
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
            color = Orange,
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
