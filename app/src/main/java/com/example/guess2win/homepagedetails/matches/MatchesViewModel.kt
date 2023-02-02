package com.example.guess2win.homepagedetails.matches

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.guess2win.data.BuilderApiClient
import com.example.guess2win.domain.Users.Google.LoginResponseModel
import com.example.guess2win.homepagedetails.matches.MatchesModel.MatchesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MatchesViewModel:ViewModel() {
    val repo  = MatchesRepo()

    private val _getAllMatches =
        MutableSharedFlow<List<MatchesResponse>>()
    val getAllMatches = _getAllMatches.asSharedFlow()


//    fun getAllMatchesFromRepo(lang:String,userID:String,date:String):MutableLiveData<List<MatchesResponse>>{
//        return  repo.getAllMatcehsByDateAndLang(lang,userID,date)
//    }
    fun getAllMatches(lang:String,userID:String,date:String){
        viewModelScope.launch(Dispatchers.IO) {
            val getMatches: List<MatchesResponse> =
                BuilderApiClient.getMatchesService().getAllMatchByDateAndLang(lang,userID,date)
            _getAllMatches.emit(getMatches)
        }
    }



}