package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0x2032FF32)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Hero section placed just above the center
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center) // Center the Hero section
                .padding(bottom = 100.dp) // Adjust this value to position it above the contact details
        ) {
            Hero("Aaron Lal", "Android Developer")
        }

        // Contact details aligned to the bottom center
        IconList(
            modifier = Modifier
                .align(Alignment.BottomCenter) // Place at the bottom center
                .padding(bottom = 16.dp) // Add padding from the bottom edge
        )
    }
}


@Composable
fun Hero(fname: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color(0xFF000000).copy(alpha = 0.5f)) // Semi-transparent dark background
                .padding(8.dp) // Optional padding inside the Box
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = fname,
            fontSize = 24.sp
        )
        Text(
            text = title,
            modifier = modifier,
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun IconList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        IconListItem(title = "+00 (00) 000 000", icon = Icons.Rounded.Phone)
        IconListItem(title = "@socialmediahandle", icon = Icons.Rounded.Share)
        IconListItem(title = "email@domain.com", icon = Icons.Rounded.Email)
    }
}


@Composable
fun IconListItem(title: String, icon: ImageVector) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(8.dp) // Adjust padding as needed
    )
    {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF3ddc84) // Same color as the title for consistency
        )
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center

        )
    }
}



@Preview(showBackground = true)
@Composable
fun Preview() {
    BusinessCardTheme {
        BusinessCard()
    }
}