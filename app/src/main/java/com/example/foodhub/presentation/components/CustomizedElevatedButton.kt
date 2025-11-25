package com.example.foodhub.presentation.components

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
import com.example.foodhub.presentation.Constants
import com.example.foodhub.presentation.ui.theme.Orange


@Composable
fun CustomizedElevatedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    loading: Boolean = false

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
        if (loading) {
            CircularProgressIndicator(
                color = Color.White
            )
        } else {
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}