package com.example.lab_2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.lab_2.viewModel.CharacterViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterScreen(viewModel: CharacterViewModel = viewModel()) {
    val characters by viewModel.characters.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Rick and Morty") },
            )
        }
    ) { innerPadding ->
        if (characters.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        } else {
            CharacterList(characters, modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun CharacterList(characters: List<com.example.lab_2.model.Character>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(characters) { index, character ->
            CharacterItem(character)
        }
    }
}

@Composable
fun CharacterItem(character: com.example.lab_2.model.Character) {
    when (character.species) {
        "Human" -> HumanCharacter(character)
        "Alien" -> AlienCharacter(character)
        else -> OtherCharacter(character)
    }
}

@Composable
fun HumanCharacter(character: com.example.lab_2.model.Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = character.name, fontWeight = FontWeight.Bold)
                Text(text = "Species: ${character.species}")
            }
        }
    }
}

@Composable
fun AlienCharacter(character: com.example.lab_2.model.Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green.copy(0.25f))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = character.name, fontWeight = FontWeight.Bold)
                Text(text = "Species: ${character.species}")
            }
        }
    }
}

@Composable
fun OtherCharacter(character: com.example.lab_2.model.Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue.copy(0.25f))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = character.name, fontWeight = FontWeight.Bold)
                Text(text = "Species: ${character.species}")
            }
        }
    }
}
