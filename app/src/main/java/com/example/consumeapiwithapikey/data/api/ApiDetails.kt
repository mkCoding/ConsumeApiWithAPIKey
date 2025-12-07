package com.example.consumeapiwithapikey.data.api

import com.example.consumeapiwithapikey.BuildConfig


object ApiDetails {

    // https://api.artsearch.io/artworks?query=dog&number=3

    const val BASE_URL = "https://api.artsearch.io/"
    const val ARTWORK_ENDPOINT = "artworks"
    val API_KEY = BuildConfig.API_KEY
}