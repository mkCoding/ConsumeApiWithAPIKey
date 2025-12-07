package com.example.consumeapiwithapikey.data.model

data class AllArtworkModel(
    val artworks: List<ArtworkModel?>? = listOf(),
    val available: Int? = 0,
    val number: Int? = 0,
    val offset: Int? = 0
)