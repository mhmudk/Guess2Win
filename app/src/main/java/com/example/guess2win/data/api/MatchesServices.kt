package com.example.guess2win.data.api

import com.example.guess2win.homepagedetails.matches.MatchesModel.MatchesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MatchesServices {
    @GET("Home/GetAllMatch/{lang}/{userId}")
    suspend fun getAllMatchByDateAndLang(
        @Path("lang") lang:String,
        @Path("userId") userId:String,
        @Query("date") date: String
    ): List<MatchesResponse>
}