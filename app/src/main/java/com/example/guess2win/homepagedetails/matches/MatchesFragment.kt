package com.example.guess2win.homepagedetails.matches


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.guess2win.IOnBackPressed
import com.example.guess2win.utils.SharedPref


class MatchesFragment : Fragment(), IOnBackPressed {
    lateinit var matchesViewModel: MatchesViewModel
    var clientIdUser :String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        matchesViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[MatchesViewModel::class.java]
        Log.d("idUser", SharedPref.getUserID())
         clientIdUser = SharedPref.getUserID()

        //matchesViewModel.getAllMatches("en",  clientIdUser,"2023-2-2")
    // getAllMatchesRemote("en", clientIdUser, "2023-1-31")


    }


    override fun onBackPressed(): Boolean {
        return false
    }


}