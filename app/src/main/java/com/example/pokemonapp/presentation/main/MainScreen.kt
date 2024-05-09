package com.example.pokemonapp.presentation.main

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokemonapp.domain.entities.Pokemon

@Composable
fun MainScreen(viewModel: MainViewModel) {

    val state = viewModel.pokemonList.observeAsState(MainScreenState.Initial)

    when (val currentState = state.value) {
        is MainScreenState.Initial -> ShowInitial()
        is MainScreenState.Loading -> ShowLoading()
        is MainScreenState.Success -> ShowList(currentState.posts)
        is MainScreenState.Error -> ShowError(currentState.exception)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonCard(pokemon: Pokemon) {
    ElevatedCard(
        modifier = Modifier.padding(8.dp),
        onClick = { /* Do something */ }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            AsyncImage(
                model = pokemon.imageUrl,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = pokemon.name,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun ShowInitial() {
    Box(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Initial Screen",
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ShowLoading() {
    Box(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun ShowList(list: List<Pokemon>) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = "Pokemon App",
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(4.dp)
        ) {
            items(list.size) { index ->
                PokemonCard(pokemon = list[index])
            }
        }
    }
}

@Composable
fun ShowError(exception: Exception) {
    Box(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Sorry, but something went wrong",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Log.d("MATAG", "exception: $exception")
    }
}

//@Preview
//@Composable
//fun ProjectThemeLight() {
//    PokemonAppTheme(
//        darkTheme = false
//    ){
//        showLoading()
//    }
//}
//@Preview
//@Composable
//fun ProjectThemeDark() {
//    PokemonAppTheme(
//        darkTheme = true
//    ){
//        showLoading()
//    }
//}