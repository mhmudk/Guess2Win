package com.example.guess2win.bottomnavigation.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.guess2win.data.BuilderApiClient
import com.example.guess2win.domain.Users.Google.Authentication
import com.example.guess2win.domain.Users.Google.Facebook.FacebookModel
import com.example.guess2win.domain.Users.Google.Facebook.LoginFacebookResponse
import com.example.guess2win.domain.Users.Google.LoginResponseModel
import com.example.guess2win.utils.SharedPref
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Flow


class LoginRepo {
    val googleMutableLiveData = MutableLiveData<LoginResponseModel>()
    val facebookMutableLiveData = MutableLiveData<LoginFacebookResponse>()


//
//    fun registerByGoogle(authentication: Authentication): MutableLiveData<LoginResponseModel> {
//        val registerResponseCall: Call<LoginResponseModel> =
//            BuilderApiClient.getUserService().logInUserByGoogle(authentication)
//        registerResponseCall.enqueue(object : Callback<LoginResponseModel> {
//            override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
//                Log.d("Response Failure", t.message.toString())
//
//            }
//            override fun onResponse(
//                call: Call<LoginResponseModel>,
//                response: Response<LoginResponseModel>
//            ) {
//                if (response.isSuccessful) {
//                    Log.d(" Response good ", response.body()!!.token.toString())
//                    googleMutableLiveData.value = response.body()!!
//                    SharedPref.setusertoken(response.body()!!.token)
//                    SharedPref.setUserID(response.body()!!.user.id)
//                    Log.d("ClientIdUSer", response.body()!!.user.id)
//
//
//                }
//            }
//        })
//        return googleMutableLiveData
//    }
//
//
//    fun registerByFacebook(authentication: FacebookModel): MutableLiveData<LoginFacebookResponse> {
//
//
//        var registerResponseCall: Call<LoginFacebookResponse> =
//            BuilderApiClient.getUserService().loginUserByFacebook(authentication)
//
//        registerResponseCall.enqueue(object : Callback<LoginFacebookResponse> {
//            override fun onFailure(call: Call<LoginFacebookResponse>?, t: Throwable?) {
//                Log.d("Response Failure", t?.message.toString())
//            }
//
//            override fun onResponse(
//                call: Call<LoginFacebookResponse>?,
//                response: Response<LoginFacebookResponse>?
//            ) {
//                if (response != null) {
//                    Log.d(" Response good ", response.body()!!.token.toString())
//                    facebookMutableLiveData.value = response.body()!!
//                    SharedPref.setusertoken(response.body()!!.token)
//                }
//            }
//        })
//        return facebookMutableLiveData
//    }
}