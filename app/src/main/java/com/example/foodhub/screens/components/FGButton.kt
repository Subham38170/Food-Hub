package com.example.foodhub.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodhub.R

//Customized Button for both Google and Facebook
@Composable
fun FGButton(
    onFaceBookButtonClick: () -> Unit,
    onGoogleButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
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