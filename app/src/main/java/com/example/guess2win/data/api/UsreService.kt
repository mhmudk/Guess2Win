package com.example.guess2win.data.api

import com.example.guess2win.domain.Users.Google.Authentication
import com.example.guess2win.domain.Users.Google.Facebook.FacebookModel
import com.example.guess2win.domain.Users.Google.Facebook.LoginFacebookResponse
import com.example.guess2win.domain.Users.Google.LoginResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UsreService {


    @POST("Account/LoginWithGoogle")
   suspend fun logInUserByGoogle(@Body authentication: Authentication): LoginResponseModel


    @POST("Account/LoginWithFacebook")
    suspend  fun loginUserByFacebook(@Body facebookModel : FacebookModel ):LoginFacebookResponse

}