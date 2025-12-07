package com.example.consumeapiwithapikey.data.api

import com.example.consumeapiwithapikey.data.model.AllArtworkModel
import com.example.consumeapiwithapikey.data.model.ArtworkModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtworkApi {
    @GET(ApiDetails.ARTWORK_ENDPOINT)
    suspend fun getAllArtwork(
        @Query("query") query:String,
        @Query("number") number:Int
    ): AllArtworkModel

}