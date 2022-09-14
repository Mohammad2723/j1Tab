package com.github.ebrahimi16153.j1tab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.ebrahimi16153.j1tab.ui.theme.J1TabTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            J1TabTheme {
                MyApp()
            }
        }
    }


    @Composable
    fun MyApp() {
        val moneyCounter = remember {
            mutableStateOf(0)
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.DarkGray
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$${moneyCounter.value}",
                    style = TextStyle(Color.White, fontWeight = FontWeight.Bold, fontSize = 30.sp)
                )
                Spacer(modifier = Modifier.height(100.dp))
                Circle(moneyCounter.value) { newVale ->
                    moneyCounter.value = newVale + 1
                }

            }
        }
    }


    @Composable
    fun Circle(moneyCounter: Int, updateMoneyCounter: (Int) -> Unit) {

        Card(
            modifier = Modifier
                .padding(20.dp)
                .size(80.dp)
                .clickable {

                    updateMoneyCounter(moneyCounter)

                },
            shape = CircleShape, elevation = 10.dp
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = "Tab ")
            }

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        J1TabTheme {
            MyApp()
        }

    }
}