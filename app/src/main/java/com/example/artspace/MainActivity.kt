package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtGallery() {
    var currentPic by remember { mutableStateOf(1) }

    when (currentPic) {
        1 -> ArtCard(
            drawableResourceId = R.drawable.art1,
            contentDescriptionResourceId = stringResource(R.string.content_description_1),
            name = stringResource(R.string.picture_name_1),
            author = stringResource(R.string.author_1),
            year = 1670,
            pictureNumber = 1,
            onButtonClick = { currentPic = it }
        )
        2 -> ArtCard(
            drawableResourceId = R.drawable.art2,
            contentDescriptionResourceId = stringResource(R.string.content_description_2),
            name = stringResource(R.string.picture_name_2),
            author = stringResource(R.string.author_2),
            year = 1550,
            pictureNumber = 2,
            onButtonClick = { currentPic = it }
        )
        3 -> ArtCard(
            drawableResourceId = R.drawable.art3,
            contentDescriptionResourceId = stringResource(R.string.content_description_3),
            name = stringResource(R.string.picture_name_3),
            author = stringResource(R.string.author_3),
            year = 2019,
            pictureNumber = 3,
            onButtonClick = { currentPic = it }
        )
        4 -> ArtCard(
            drawableResourceId = R.drawable.art4,
            contentDescriptionResourceId = stringResource(R.string.content_description_4),
            name = stringResource(R.string.picture_name_4),
            author = stringResource(R.string.author_4),
            year = 1776,
            pictureNumber = 4,
            onButtonClick = { currentPic = it }
        )
        5 -> ArtCard(
            drawableResourceId = R.drawable.art5,
            contentDescriptionResourceId = stringResource(R.string.content_description_5),
            name = stringResource(R.string.picture_name_5),
            author = stringResource(R.string.author_5),
            year = 1818,
            pictureNumber = 5,
            onButtonClick = { currentPic = it }
        )
        6 -> ArtCard(
            drawableResourceId = R.drawable.art6,
            contentDescriptionResourceId = stringResource(R.string.content_description_6),
            name = stringResource(R.string.picture_name_6),
            author = stringResource(R.string.author_6),
            year = 1880,
            pictureNumber = 6,
            onButtonClick = { currentPic = it }
        )
        7 -> ArtCard(
            drawableResourceId = R.drawable.art7,
            contentDescriptionResourceId = stringResource(R.string.content_description_7),
            name = stringResource(R.string.picture_name_7),
            author = stringResource(R.string.author_7),
            year = 1818,
            pictureNumber = 7,
            onButtonClick = { currentPic = it }
        )
        8 -> ArtCard(
            drawableResourceId = R.drawable.art8,
            contentDescriptionResourceId = stringResource(R.string.content_description_8),
            name = stringResource(R.string.picture_name_8),
            author = stringResource(R.string.author_8),
            year = 1824,
            pictureNumber = 8,
            onButtonClick = { currentPic = it }
        )
        9 -> ArtCard(
            drawableResourceId = R.drawable.art9,
            contentDescriptionResourceId = stringResource(R.string.content_description_9),
            name = stringResource(R.string.picture_name_9),
            author = stringResource(R.string.author_9),
            year = 1705,
            pictureNumber = 9,
            onButtonClick = { currentPic = it }
        )
        10 -> ArtCard(
            drawableResourceId = R.drawable.art10,
            contentDescriptionResourceId = stringResource(R.string.content_description_10),
            name = stringResource(R.string.picture_name_10),
            author = stringResource(R.string.author_10),
            year = 1857,
            pictureNumber = 10,
            onButtonClick = { currentPic = it }
        )
    }
}

@Composable
fun ArtCard(
    drawableResourceId: Int,
    contentDescriptionResourceId: String,
    name: String,
    author: String,
    year: Int,
    pictureNumber: Int,
    onButtonClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var currentPicture = pictureNumber

    val windowInfo = rememberWindowInfo()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        // small screens
        if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
            Column {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier
                        .padding(top = 80.dp)
                        .shadow(elevation = 5.dp)
                ) {
                    Image(
                        painter = painterResource(id = drawableResourceId),
                        contentDescription = contentDescriptionResourceId,
                        modifier = modifier.padding(40.dp)
                    )
                }
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp)
                        .background(color = Color(0xFFECEBF4))
                        .padding(20.dp)
                ) {
                    Text(
                        text = name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Light
                    )
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Bottom,
                        modifier = modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = author,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                        )
                        Text(
                            text = "(${year})"
                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp)
            ) {
                Button(
                    modifier = modifier
                        .weight(1f)
                        .padding(end = 20.dp),
                    onClick = {
                        if (pictureNumber > 1) {
                            currentPicture = pictureNumber - 1
                        }
                        onButtonClick(currentPicture)
                    },
                ) {
                    Text(text = stringResource(R.string.previous_btn))
                }
                Button(
                    modifier = modifier
                        .weight(1f)
                        .padding(start = 20.dp),
                    onClick = {
                        if (pictureNumber < 10) {
                            currentPicture = pictureNumber + 1
                        }
                        onButtonClick(currentPicture)
                    },
                ) {
                    Text(text = stringResource(R.string.next_btn))
                }
            }
            // large screens
        } else {
            Column(
                modifier.fillMaxWidth(0.5f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier
                        .padding(top = 80.dp)
                        .shadow(elevation = 5.dp)
                ) {
                    Image(
                        painter = painterResource(id = drawableResourceId),
                        contentDescription = contentDescriptionResourceId,
                        modifier = modifier.padding(40.dp)
                    )
                }
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp)
                        .background(color = Color(0xFFECEBF4))
                        .padding(20.dp)
                ) {
                    Text(
                        text = name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Light
                    )
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Bottom,
                        modifier = modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = author,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                        )
                        Text(
                            text = "(${year})"
                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp)
            ) {
                Button(
                    modifier = modifier
                        .width(165.dp)
                        .padding(end = 20.dp),
                    onClick = {
                        if (pictureNumber > 1) {
                            currentPicture = pictureNumber - 1
                        }
                        onButtonClick(currentPicture)
                    },
                ) {
                    Text(text = stringResource(R.string.previous_btn))
                }
                Button(
                    modifier = modifier
                        .width(165.dp)
                        .padding(start = 20.dp),
                    onClick = {
                        if (pictureNumber < 10) {
                            currentPicture = pictureNumber + 1
                        }
                        onButtonClick(currentPicture)
                    },
                ) {
                    Text(text = stringResource(R.string.next_btn))
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceApp() {
    ArtSpaceTheme {
        ArtGallery()
    }
}