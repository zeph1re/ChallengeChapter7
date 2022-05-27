package binar.ganda.challengechapter7.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieApi {

    private  val logging : HttpLoggingInterceptor
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

    private  val clint = OkHttpClient.Builder().addInterceptor(logging).build()

    val instance : MovieService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(MovieService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clint)
            .build()
        retrofit.create(MovieService::class.java)
    }
}