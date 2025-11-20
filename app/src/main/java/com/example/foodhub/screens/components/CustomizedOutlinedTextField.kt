package com.example.foodhub.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodhub.screens.Constants
import com.example.foodhub.screens.ui.theme.Orange



@Composable
fun CustomizedOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeHolder: String,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    Column(
        modifier = modifier
    ) {
        label?.let {
            Text(
                text = it,
                color = Color.Black.copy(alpha = 0.6f),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
        }

        OutlinedTextField(

            modifier = Modifier
                .fillMaxWidth(),
            textStyle = TextStyle(fontSize = 20.sp),
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(Constants.OutlinedTextFieldRoundedCornerShape),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Orange,
                unfocusedBorderColor = Color.Black.copy(0.1f),
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            singleLine = true,
            placeholder = {
                Text(
                    text = placeHolder,
                    fontSize = 16.sp,
                    color = Color.Black.copy(alpha = 0.4f),
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
        )

    }
}