package com.example.lab_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab_2.ui.screens.CharacterScreen
import com.example.lab_2.ui.theme.Lab_2Theme
import com.example.lab_2.ui.screens.CharacterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_2Theme(darkTheme = true) {
                CharacterScreen()
            }
        }
    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppTopBar(viewModel: CharacterViewModel) {
    TopAppBar(
        title = { Text(text = "Rick and Morty") },
        actions = {
            IconButton(
                onClick = {
                    viewModel.fetchCharacters()
                }
            ) {
                Icon(Icons.Default.Refresh, contentDescription = "Обновить")
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun CharacterViewPreview() {
    Lab_2Theme(darkTheme = true) {
        CharacterScreen()
    }
}