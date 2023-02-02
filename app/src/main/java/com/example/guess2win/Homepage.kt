package com.example.guess2win

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.guess2win.bottomnavigation.login.LoginViewModel
import com.example.guess2win.databinding.FragmentHomepageBinding
import com.example.guess2win.domain.Users.Google.Facebook.FacebookModel
import com.example.guess2win.homepagedetails.Cahmpoins
import com.example.guess2win.homepagedetails.PointsMore
import com.example.guess2win.homepagedetails.Rating
import com.example.guess2win.homepagedetails.matches.MatchesFragment
import com.example.guess2win.homepagedetails.more.More
import com.example.guess2win.utils.SharedPref
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.GraphResponse
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.json.JSONObject


class Homepage : Fragment(), IOnBackPressed {

lateinit var loginViewmodel:LoginViewModel
    private lateinit var binding: FragmentHomepageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        loginViewmodel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[LoginViewModel::class.java]
        fragmentManager?.beginTransaction()?.replace(R.id.frameLayout, MatchesFragment())?.commit()
        bottomNavigation()
        getInfoFromFacebookLogin()
        lifecycleScope.launch(){
            loginViewmodel.loginfacebookByStateFlow.collect(){
            SharedPref.setusertoken(it.token)
            SharedPref.setUserID(it.user.id)
                Log.d("Token is ", SharedPref.getusertoken())
                Log.d("User ID  is ", SharedPref.getUserID())
            }
        }

        return binding.root

    }

    private fun getInfoFromFacebookLogin() {
        val accessToken = AccessToken.getCurrentAccessToken()
        val request = GraphRequest.newMeRequest(
            accessToken,
            object : GraphRequest.GraphJSONObjectCallback {
                override fun onCompleted(
                    `object`: JSONObject?,
                    response: GraphResponse?
                ) {
                    try {
                        val facebookUserModel=FacebookModel(
                            `object`!!.getString("name"),
                            `object`!!.getString("id")
                        )
                        loginViewmodel.getResponseFacebookUser(facebookUserModel)

                    } catch (e: Exception) {
                        Toast.makeText(requireContext(), "Error${e.message}", Toast.LENGTH_LONG)
                            .show()
                    }

                }
            })
        val parameters = Bundle()
        parameters.putString("fields", "id,name,link")
        request.parameters = parameters
        request.executeAsync()
    }

    fun bottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            lateinit var fragment: Fragment

            when (it.itemId) {
                R.id.home_bottom -> fragment = MatchesFragment()
                R.id.champoion_bottom -> fragment = Cahmpoins()
                R.id.points_more_bottom -> fragment = PointsMore()
                R.id.rating_bottom -> fragment = Rating()
                R.id.more_bottom -> fragment = More()
            }
            fragmentManager?.beginTransaction()?.replace(R.id.frameLayout, fragment)?.commit()
            return@setOnItemSelectedListener true
        }
    }

    override fun onBackPressed(): Boolean {
        return false
    }
}
