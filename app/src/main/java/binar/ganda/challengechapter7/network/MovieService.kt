package binar.ganda.challengechapter7.network

import binar.ganda.challengechapter7.BuildConfig
import binar.ganda.challengechapter7.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = BuildConfig.MOVIEDB_API_KEY


    }

    @GET( "movie/now_playing?api_key= $API_KEY")
    suspend fun getNowPlayingMovies(@Query("page") position : Int ) : MovieResponse
}