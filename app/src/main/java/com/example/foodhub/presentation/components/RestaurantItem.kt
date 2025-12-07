package com.example.foodhub.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.foodhub.R
import com.example.foodhub.domain.model.resturant.Restaurant


@Composable
fun RestaurantItem(
    restaurant: Restaurant,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(16.dp),
                ambientColor = Color.Gray.copy(0.8f),
                spotColor = Color.Gray.copy(0.8f),
                clip = false
            )
            .background(Color.White, RoundedCornerShape(16.dp))
            .width(320.dp)
            .height(300.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                model = restaurant.imageUrl,
                contentDescription = restaurant.name,
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .fillMaxWidth()
                    .height(160.dp),
                contentScale = ContentScale.FillBounds
            )
            Row(
                modifier = Modifier
                    .padding(start = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = restaurant.name,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    painter = painterResource(id = R.drawable.green_tick),
                    contentDescription = "",
                    modifier = Modifier
                        .size(20.dp)
                        .padding(start = 4.dp),
                    tint = Color.Unspecified
                )
            }

            DeliveryInfo(
                deliveryCost = 10,
                deliveryTime = "12-45mins"

            )
            FoodItem(
                foodItems = listOf("Burger", "Chicken", "Fast Food")
            )

        }

        ReviewCard(
            review = "4.5",
            modifier = Modifier
                .align(Alignment.TopStart)
        )
        FavoriteIcon(
            onClick = {},
            modifier = Modifier
                .align(Alignment.TopEnd)
        )
    }

}


@Composable
private fun FoodItem(
    foodItems: List<String>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(foodItems) {
            SuggestionChip(
                onClick = {},
                label = {
                    Text(
                        text = it
                    )
                }
            )
        }
    }
}

//A Row contains delivery info such as cost of delivery and expected time of delivery
@Composable
private fun DeliveryInfo(
    deliveryCost: Int,
    deliveryTime: String
) {
    Row(
        modifier = Modifier
            .padding(start = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.rider),
            contentDescription = "",
            modifier = Modifier
                .size(24.dp)
                .padding(end = 4.dp),
            tint = colorResource(id = R.color.orange)
        )
        Text(
            text = if (deliveryCost != 0) "\u20B9$deliveryCost Delivery" else "Free Delivery"
        )
        Spacer(modifier = Modifier.width(20.dp))
        Icon(
            painter = painterResource(id = R.drawable.alarm),
            contentDescription = "",
            modifier = Modifier
                .size(20.dp),
            tint = colorResource(id = R.color.orange)
        )
        Text(
            text = deliveryTime
        )
    }
}


//Favorite button
@Composable
private fun FavoriteIcon(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .size(36.dp)
            .background(color = colorResource(id = R.color.orange), shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_favorite_24),
            contentDescription = "Favorite",
            tint = Color.White,
            modifier = Modifier
                .size(28.dp)
        )
    }
}


//This shows the review of the resturant
@Composable
private fun ReviewCard(
    review: String,
    modifier: Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = modifier
            .padding(8.dp)

    ) {
        Row(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = review,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Icon(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "Rating",
                modifier = Modifier
                    .size(20.dp)
                    .padding(end = 4.dp),
                tint = colorResource(id = R.color.golden_yellow)
            )
            Text(
                text = "(25+)",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }


}


