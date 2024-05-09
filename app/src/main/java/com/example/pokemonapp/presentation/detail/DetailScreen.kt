package com.example.pokemonapp.presentation.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokemonapp.domain.entities.Pokemon
import com.example.pokemonapp.domain.entities.Stat
import com.example.pokemonapp.ui.theme.Gray500

@Composable
fun DetailScreen(pokemon: Pokemon) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp)
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        OutlinedCard(Modifier.fillMaxSize()) {}
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            AsyncImage(
                model = pokemon.imageUrl,
                modifier = Modifier.size(300.dp),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(8.dp))
            Info(pokemon.types, pokemon.weight, pokemon.height)
            StatList(pokemon.stats)
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}


@Composable
fun StatElement(text: String, data: Int) {
    Row (
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 18.sp,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Surface(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth().weight(4f),
            border = BorderStroke(
                width = 1.dp,
                color = Gray500
            )
        ) {
            LinearProgressIndicator(
                progress = data / 100f,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(18.dp),
                trackColor = MaterialTheme.colorScheme.onSecondary
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Composable
fun StatList(stats: List<Stat>) {
    Column {
        for (stat in stats) {
            StatElement(stat.name, stat.score)
        }
    }
}

@Composable
fun InfoItem(text: String, data: String) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = data,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun Info(types: List<String>, weight: String, height: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            for (type in types) {
                Type(type)
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            InfoItem("Weight", weight)
            InfoItem("Height", height)
        }
    }
}

@Composable
fun Type(type: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Gray500)
    ) {
        Text(
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
            text = type,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            color = Color.White
        )
    }
}

//@Preview
//@Composable
//fun ProjectThemeLight() {
//    PokemonAppTheme(
//        darkTheme = false
//    ){
//        StatList()
//    }
//}
//@Preview
//@Composable
//fun ProjectThemeDark() {
//    PokemonAppTheme(
//        darkTheme = true
//    ){
//        StatList()
//    }
//}