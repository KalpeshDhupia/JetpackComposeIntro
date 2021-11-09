package com.example.jetpackcomposeintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Title()
            //UserList()
            var sizeState by remember {
                mutableStateOf(200.dp)
            }
            val size by animateDpAsState(targetValue = sizeState, spring(
                Spring.DampingRatioHighBouncy
            ))
            Box(
                modifier = Modifier
                    .size(size)
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    sizeState += 50.dp
                }) {
                    Text("Increase Size")
                }
            }
        }
    }


/*@Composable
fun Title() {
    val context = LocalContext.current
    Text(
        text = "Happy Diwali",
        fontSize = 40.sp,
        color = Color.Magenta,
        fontFamily = FontFamily.Cursive,
        modifier = Modifier.clickable {
            Toast.makeText(context, "item Clicked", Toast.LENGTH_SHORT).show()
        })
}*/

    data class User(
        val id: Int
    )

    val users = listOf(
        User(1), User(1), User(1), User(1), User(1), User(1), User(1)
    )

    @Composable
    fun UserList() {
        /* Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
             for (i in 1..10){
                 UserCard()
             }
         }*/
        LazyColumn() {
            items(users) { user ->
                UserCard()

            }
        }
    }

    @Composable
    fun UserCard() {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight()
                .padding(12.dp)
                .border(width = 1.dp, color = Color.Gray)
                .padding(12.dp)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(text = stringResource(id = R.string.app_name))
                Button(onClick = {

                }) {
                    Text(text = "View Profile")
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
            //Title()
            UserCard()
        }

    }
}
