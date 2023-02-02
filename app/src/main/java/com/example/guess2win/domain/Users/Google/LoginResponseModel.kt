package com.example.guess2win.domain.Users.Google

data class LoginResponseModel(
    val token: String,
    val user: User
)

data class User(
    val clientId: String,
    val id: String,
    val image: Any,
    val phoneNumber: Any,
    val role: String,
    val userName: String
)