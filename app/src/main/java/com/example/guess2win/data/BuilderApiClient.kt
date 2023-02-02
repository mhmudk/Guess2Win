package com.example.guess2win.data

import com.example.guess2win.data.api.MatchesServices
import com.example.guess2win.data.api.UsreService
import com.example.guess2win.utils.Const
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object BuilderApiClient {

    fun getRetrofit(): Retrofit {
        val httpInterceptor = HttpLoggingInterceptor()
        httpInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        var okHttpClient: OkHttpClient =
            OkHttpClient.Builder()
    //                .connectTimeout(30, TimeUnit.MINUTES)
    //                .writeTimeout(30, TimeUnit.MINUTES) // write timeout
    //                .readTimeout(30, TimeUnit.MINUTES)
                .addInterceptor(httpInterceptor)
                .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit
    }

    fun getUserService(): UsreService {
        val userServise: UsreService = getRetrofit().create(UsreService::class.java)
        return userServise
    }

    fun getMatchesService(): MatchesServices {
        val matchesServices: MatchesServices = getRetrofit().create(MatchesServices::class.java)
        return matchesServices
    }
}