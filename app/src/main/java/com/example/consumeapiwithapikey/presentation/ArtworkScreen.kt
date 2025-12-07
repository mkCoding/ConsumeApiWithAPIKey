package com.example.consumeapiwithapikey.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.consumeapiwithapikey.data.model.AllArtworkModel
import com.example.consumeapiwithapikey.data.model.ArtworkModel

@Composable
fun ArtworkScreen(
    state: ArtWorkState
){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        when(state){
            is ArtWorkState.Loading->{
                CircularProgressIndicator()
            }

            is ArtWorkState.Success -> {
                LazyColumn(
                    modifier = Modifier.padding(16.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val artworkList = state.artWorkData.artworks.orEmpty()
                   items (artworkList){item ->
                       Text("${item?.title}")

                   }
                }
            }
            is ArtWorkState.Error->{
                Text("${state.message}")

            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun ArtworkScreenPreview(){
    ArtworkScreen(
        ArtWorkState.Success(
            AllArtworkModel(
                artworks =  listOf(
                    ArtworkModel(1, "", "Ascending")
                )
            )
        )
    )
}
