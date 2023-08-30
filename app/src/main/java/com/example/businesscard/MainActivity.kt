package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.height(30.dp))
        AboutBlock(Modifier.weight(0.8f))
        ContactInformationBlock(Modifier.weight(0.2f))
        Spacer(Modifier.height(30.dp))
    }
}

@Composable
fun AboutBlock(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.main_photo),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .border(
                    BorderStroke(2.dp, Color(0xFF006C3A)),
                    CircleShape
                )
                .clip(CircleShape)
        )
        Text(
            text = stringResource(R.string.full_name),
            fontSize = 44.sp,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = stringResource(R.string.title),
            color = Color(0xFF006C3A),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactInformationBlock(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
    ) {
        ContactRow(
            contactIcon = Icons.Filled.Phone,
            contactText = stringResource(id = R.string.phone_number)
        )
        ContactRow(
            contactIcon = Icons.Filled.Send,
            contactText = stringResource(id = R.string.telegram_link)
        )
        ContactRow(
            contactIcon = Icons.Filled.Email,
            contactText = stringResource(id = R.string.email)
        )
    }
}

@Composable
fun ContactRow(
    contactIcon: ImageVector,
    contactText: String,
    tintColor: Color = Color(0xFF006C3A)
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector = contactIcon,
            tint = tintColor,
            contentDescription = null,
            modifier = Modifier.padding(8.dp)
        )
        Text(text = contactText)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}