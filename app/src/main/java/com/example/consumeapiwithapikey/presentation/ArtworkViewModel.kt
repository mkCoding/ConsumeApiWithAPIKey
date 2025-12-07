package com.example.consumeapiwithapikey.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumeapiwithapikey.data.model.AllArtworkModel
import com.example.consumeapiwithapikey.data.model.ArtworkModel
import com.example.consumeapiwithapikey.domain.ArtworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

@HiltViewModel
class ArtworkViewModel @Inject constructor(
    private val artworkRepository: ArtworkRepository
): ViewModel() {

    // art state variable to pass to UI
    private val _artworkState = MutableStateFlow<ArtWorkState>(ArtWorkState.Loading)
    val artworkState: StateFlow<ArtWorkState> = _artworkState

    init {
        loadArtworkData()
    }

    private fun loadArtworkData() {
        _artworkState.value = ArtWorkState.Loading

        viewModelScope.launch {
            try {
                // create variable to hold main artwork data
                val data = artworkRepository.getAllArtwork(query = "hug", number = 9)
                _artworkState.value = ArtWorkState.Success(data)

            }catch (e: IOException){
                _artworkState.value = ArtWorkState.Error("IO Exception: ${e.message}")
            }catch (e: Exception){
                _artworkState.value = ArtWorkState.Error("${e.message}")
            }

        }

    }
}

sealed class ArtWorkState{
    object Loading: ArtWorkState()
    data class Success(val artWorkData: AllArtworkModel): ArtWorkState()
    data class Error(val message:String): ArtWorkState()
}