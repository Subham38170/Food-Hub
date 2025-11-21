package com.example.foodhub.screens.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.foodhub.screens.Constants
import com.example.foodhub.screens.ui.theme.Orange


@Composable
fun CustomizedElevatedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    showCircularProgressIndicator: Boolean = false

) {

    ElevatedButton(
        modifier = modifier
            .height(Constants.CustmizedButtonHeight),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Orange,
            contentColor = Color.White
        )
    ) {
        if (showCircularProgressIndicator) {
            CircularProgressIndicator()
        } else {
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}