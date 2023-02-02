package com.example.guess2win.homepagedetails.matches

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.guess2win.data.BuilderApiClient
import com.example.guess2win.homepagedetails.matches.MatchesModel.MatchesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchesRepo {
  private  val getAllMatchesLiveData = MutableLiveData<List<MatchesResponse>>()


}
