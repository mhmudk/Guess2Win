package com.example.guess2win.data.repository

import com.example.guess2win.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun  loginByGoogle() = apiHelper.loginBygoogleApi()
}