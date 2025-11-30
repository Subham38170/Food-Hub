package com.example.foodhub.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp



//Text format in screen
// Horizontal divider in between text
@Composable
fun TextWithHorizontalDivider(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.White
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            color = color,
            modifier = Modifier.weight(0.3f)
        )
        Text(
            text = text,
            color = color,
            modifier = Modifier.weight(0.4f),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraLight
        )
        HorizontalDivider(
            color = color,
            modifier = Modifier.weight(0.3f)
        )


    }
}