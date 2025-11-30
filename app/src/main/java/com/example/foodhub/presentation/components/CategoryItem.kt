package com.example.foodhub.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.foodhub.R
import com.example.foodhub.domain.model.product.Category


//Category Item contains the image of category and its name
@Composable
fun CategoryItem(
    category: Category,
    onClick: () -> Unit,
    isSelected: Boolean = false
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(44.dp),
                ambientColor = Color.Gray.copy(0.8f),
                spotColor = Color.Gray.copy(0.8f)
            )
            .clip(RoundedCornerShape(44.dp))
            .background(if (isSelected) colorResource(id = R.color.orange) else Color.White)
            .height(140.dp)
            .width(88.dp)

            .clickable(
                onClick = onClick
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = category.imageUrl,
            contentDescription = category.name,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = category.name,
            fontWeight = FontWeight.ExtraBold,
            color = if (isSelected) Color.White else Color.Black,
            maxLines = 2,
            textAlign = TextAlign.Center
        )
    }
}

