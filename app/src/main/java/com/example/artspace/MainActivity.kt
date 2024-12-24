package com.example.artspace

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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
    ) {
        ArtworkWall()
        ArtworkDescriptor()
        DisplayController()
    }
}

@Composable
fun ArtworkWall(
    //horizontalAlignment = Alignment.CenterHorizontally,
    modifier: Modifier = Modifier
) {
    Box(
        //horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
            .shadow(56.dp)
            .size(390.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            Image(
                painter = painterResource(R.drawable.artapp_image_1),
                contentDescription = null, //text(R.string.artwork_title_1),
                //horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                //.size(390.dp)
            )
        }
    }
}

@Composable
fun ArtworkDescriptor(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(color = Color.Gray)
            .padding(16.dp)
    ) {
        Column(
            modifier = modifier
        ) {
            Text(
                text = stringResource(R.string.artwork_title_1),
                fontSize = 36.sp,
                modifier = modifier
            )
            Row() {
                Text(
                    text = stringResource(R.string.artwork_artist_1),
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.artwork_year_1),
                    modifier = modifier
                )
            }
        }
    }
}

@Composable
fun DisplayController(modifier: Modifier = Modifier) {
    var page = 1 //by remember { mutableStateOf(1) }
    Row(
        modifier = modifier
    ) {
        Button(
            onClick = { page = 1 },
            modifier = modifier
                .width(160.dp)
        ) {
            Text(
                stringResource(R.string.previous)
            )
        }
        Spacer(modifier = Modifier.width(30.dp))
        Button(
            onClick = { page = 1 },
            modifier = modifier
                .width(160.dp)
        ) {
            Text(
                stringResource(R.string.next)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkWallPreview() {
    ArtSpaceTheme {
        ArtworkWall()
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkDescriptorPreview() {
    ArtSpaceTheme {
        ArtworkDescriptor()
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayControllerPreview() {
    ArtSpaceTheme {
        DisplayController()
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}