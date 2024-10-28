package com.example.myapplicationtd1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollApp()
        }
    }
}

@Composable
fun DiceRollApp() {
    var diceNumber by remember { mutableStateOf(1) }
    var player1Score by remember { mutableStateOf(0) }
    var player2Score by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Dice Roll: $diceNumber", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            diceNumber = (1..6).random()
            player1Score += diceNumber
        }) {
            Text("Roll Dice")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text("Player 1 Score: $player1Score")
        Text("Player 2 Score: $player2Score")

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            diceNumber = 1
            player1Score = 0
            player2Score = 0
        }) {
            Text("Reset Game")
        }
    }
}
@Composable
fun DiceRollApp(diceViewModel: DiceViewModel) {
    val diceNumber by diceViewModel.diceNumber.observeAsState(1)
    val player1Score by diceViewModel.player1Score.observeAsState(0)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Dice Roll: $diceNumber")
        Button(onClick = { diceViewModel.rollDice() }) {
            Text("Roll Dice")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Player 1 Score: $player1Score")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { diceViewModel.resetGame() }) {
            Text("Reset Game")
        }
    }
}
