package binar.ganda.challengechapter7.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import binar.ganda.challengechapter7.model.Movie
import binar.ganda.challengechapter7.network.MovieApi
import binar.ganda.challengechapter7.network.MovieService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel(){

    lateinit var liveDataMovie: MutableLiveData<List<Movie>>

    init {

        liveDataMovie = MutableLiveData()
    }

    fun getLiveMovieObserver(): MutableLiveData<List<Movie>> {
        return liveDataMovie
    }


    fun makeApiMovie() {
        MovieApi.instance.getNowPlayingMovies()
            .enqueue(object : Callback<List<GetAllBukuResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetAllBukuResponseItem>>,
                    response: Response<List<GetAllBukuResponseItem>>
                ) {
                    if (response.isSuccessful) {
                        liveDataBuku.postValue(response.body())
                    } else {
                    }

                }

                override fun onFailure(call: Call<List<GetAllBukuResponseItem>>, t: Throwable) {
                }

            })
    }
}