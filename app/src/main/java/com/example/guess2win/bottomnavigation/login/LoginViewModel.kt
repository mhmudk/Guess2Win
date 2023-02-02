package com.example.guess2win.bottomnavigation.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.guess2win.data.BuilderApiClient
import com.example.guess2win.domain.Users.Google.Authentication
import com.example.guess2win.domain.Users.Google.Facebook.FacebookModel
import com.example.guess2win.domain.Users.Google.Facebook.LoginFacebookResponse
import com.example.guess2win.domain.Users.Google.LoginResponseModel
import com.example.guess2win.domain.Users.Google.User
import com.example.guess2win.utils.Resource
import com.example.guess2win.utils.SharedPref
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.awaitResponse

class LoginViewModel : ViewModel() {
    private val _loginGoogleByStateFlow =
        MutableSharedFlow<LoginResponseModel>()
    private val _loginFacebookByStateFlow =
        MutableSharedFlow<LoginFacebookResponse>()

    val loginGoogleByStateFlow = _loginGoogleByStateFlow.asSharedFlow()
    val loginfacebookByStateFlow = _loginFacebookByStateFlow.asSharedFlow()
    val repoLogin = LoginRepo()



    fun getResponseGoogleUser(authentication: Authentication) {
        viewModelScope.launch(IO) {
            val registerResponseCall: LoginResponseModel =
                BuilderApiClient.getUserService().logInUserByGoogle(authentication)
            val mUser = registerResponseCall.user

            _loginGoogleByStateFlow.emit(registerResponseCall)
        }
    }

    fun getResponseFacebookUser(authentication: FacebookModel) {
        viewModelScope.launch(IO) {
            val registerResponseCall: LoginFacebookResponse =
                BuilderApiClient.getUserService().loginUserByFacebook(authentication)
            val mUser = registerResponseCall.user

            _loginFacebookByStateFlow.emit(registerResponseCall)
        }
    }





}