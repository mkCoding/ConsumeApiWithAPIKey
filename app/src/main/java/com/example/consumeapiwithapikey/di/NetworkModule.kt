package com.example.consumeapiwithapikey.di

import com.example.consumeapiwithapikey.data.api.ApiDetails
import com.example.consumeapiwithapikey.data.api.ArtworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    // Provide OKHTTP to be able to pass the api key to retrofit to successfully hit the api
    @Provides
    @Singleton
    fun providesOKHttp(): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor { chain->
                val request = chain.request().newBuilder()
                    .addHeader("x-api-key", ApiDetails.API_KEY)
                    .build()
                chain.proceed(request)
            }.build()

    }

    // provide retrofit
    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl(ApiDetails.BASE_URL)
        .client(okHttpClient) // Pass the okHttpClient here which will tie header to api call
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    // provide ArtworkApi
    @Provides
    @Singleton
    fun providesArtWorkApi(retrofit: Retrofit): ArtworkApi{
        return retrofit.create(ArtworkApi::class.java)
    }


}