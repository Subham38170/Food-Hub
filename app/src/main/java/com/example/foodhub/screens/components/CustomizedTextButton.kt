package com.example.foodhub.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodhub.screens.ui.theme.Orange


//Customized text button has prefix text and with the actual text button with orange color
@Composable
fun CustomizedTextButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    prefixText: String? = null,
    prefixTextColor: Color = Color.White
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        prefixText?.let {
            Text(
                text = prefixText,
                color = prefixTextColor,
                fontSize = 14.sp
            )
        }
        TextButton(
            onClick = onClick, contentPadding = PaddingValues(0.dp)
        ) {
            Text(

                text = text,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                color = Orange,
                fontSize = 14.sp
            )
        }
    }
}

