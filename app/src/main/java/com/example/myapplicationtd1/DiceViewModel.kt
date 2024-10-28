package com.example.myapplicationtd1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiceViewModel : ViewModel() {
    private val _diceNumber = MutableLiveData(1)
    val diceNumber: LiveData<Int> get() = _diceNumber

    private val _player1Score = MutableLiveData(0)
    val player1Score: LiveData<Int> get() = _player1Score

    fun rollDice() {
        val rolledNumber = (1..6).random()
        _diceNumber.value = rolledNumber
        _player1Score.value = _player1Score.value?.plus(rolledNumber)
    }

    fun resetGame() {
        _diceNumber.value = 1
        _player1Score.value = 0
    }
}
