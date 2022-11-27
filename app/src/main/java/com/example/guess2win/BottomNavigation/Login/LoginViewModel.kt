package com.example.guess2win.BottomNavigation.Login

import androidx.lifecycle.ViewModel
import com.example.guess2win.Model.User

class LoginViewModel: ViewModel() {
    val repoLogin=LoginRepo()
    fun uploadUserDataToRealtime(user:User){
        repoLogin.uploadUserDataToRealtimeDB(user = user)
    }
}