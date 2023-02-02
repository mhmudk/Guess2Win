package com.example.guess2win.data.api

import com.example.guess2win.domain.Users.Google.Authentication

class  ApiHelper(private val apiUserService: UsreService,
                 private val apiMatchesServices: MatchesServices,
                val authentication: Authentication) {
    suspend fun loginBygoogleApi() = apiUserService.logInUserByGoogle(authentication)
}