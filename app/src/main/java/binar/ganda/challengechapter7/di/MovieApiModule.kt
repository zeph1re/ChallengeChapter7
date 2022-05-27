package binar.ganda.challengechapter7.di

import binar.ganda.challengechapter7.network.MovieService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@Singleton
object MovieApiModule {

    private val BASE_URL = "https://api.themoviedb.org/"

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(MovieService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit) : MovieService =
        retrofit.create(MovieService::class.java)

}