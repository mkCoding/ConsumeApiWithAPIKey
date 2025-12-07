package com.example.consumeapiwithapikey.domain

import com.example.consumeapiwithapikey.data.api.ArtworkApi
import javax.inject.Inject

class ArtworkRepository @Inject constructor(
    private val artworkApi: ArtworkApi
) {
    suspend fun getAllArtwork(
        query:String,
        number:Int
    ) = artworkApi.getAllArtwork(query,number)


}