package com.example.lab_2.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab_2.ui.theme.Lab_2Theme
import com.example.lab_2.viewModel.CharacterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_2Theme(darkTheme = true) {
                val characterViewModel: CharacterViewModel = viewModel()
                CharacterScreen(viewModel = characterViewModel)
            }
        }
    }
}