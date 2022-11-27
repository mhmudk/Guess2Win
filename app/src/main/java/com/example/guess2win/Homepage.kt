package com.example.guess2win


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.guess2win.HomepageDetails.Cahmpoins
import com.example.guess2win.HomepageDetails.MatchesandAnticiptions.Matches
import com.example.guess2win.HomepageDetails.More.More
import com.example.guess2win.HomepageDetails.More.PrizeFragment
import com.example.guess2win.HomepageDetails.PointsMore
import com.example.guess2win.HomepageDetails.Rating
import com.example.guess2win.Model.User
import com.example.guess2win.databinding.FragmentHomepageBinding

import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.GraphResponse
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import org.json.JSONObject


class Homepage : Fragment() {


     private lateinit var binding: FragmentHomepageBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)

      //  initGoogleSignIn()
    //    getInfoFromFacebookLogin()
        fragmentManager?.beginTransaction()?.replace(R.id.frameLayout, Matches())?.commit()

        bottomNavigation()
        val acc = GoogleSignIn.getLastSignedInAccount(requireContext())

//getInfoFromFacebookSignIn()

        return binding.root

    }

/*
    //    private fun initGoogleSignIn() {
    //        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
    //            .requestIdToken(getString(R.string.google_cline))
    //            .requestEmail()
    //            .build()
    //
    //        googlesigninClinet = GoogleSignIn.getClient(requireContext(), gso)
    //
    //    }


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
                            uploadUserDataToRealtimeDB(
                                User(
    //                                `object`!!.getString("id"),
    //                                `object`.getString("name"),
    //                                `object`.getString("email")
                                "","m","d"
                                )
                            )
                            Toast.makeText(
                                requireContext(),
                                "Upload Data Successesfully",
                                Toast.LENGTH_SHORT
                            ).show()

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

        fun uploadUserDataToRealtimeDB(user: User) {
            user.id = FirebaseAuth.getInstance().currentUser!!.uid
            FirebaseDatabase.getInstance().getReference("Users").child(
                FirebaseAuth.getInstance().currentUser!!.uid
            ).setValue(user).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("realtime", "success")
                } else {
                    Log.d("realtime", "Failure")
                }
            }
        }


     */
     fun bottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            lateinit var fragment: Fragment

            when (it.itemId) {
                R.id.home_bottom -> fragment = Matches()
                R.id.champoion_bottom -> fragment = Cahmpoins()
                R.id.points_more_bottom -> fragment = PointsMore()
                R.id.rating_bottom -> fragment = Rating()
                R.id.more_bottom -> fragment = More()
            }
            fragmentManager?.beginTransaction()?.replace(R.id.frameLayout, fragment)?.commit()
            return@setOnItemSelectedListener true
        }
    }

     fun getInfoFromFacebookLogin() {
        val accessToken = AccessToken.getCurrentAccessToken()
        val request = GraphRequest.newMeRequest(
            accessToken,
            object : GraphRequest.GraphJSONObjectCallback {
                override fun onCompleted(
                    `object`: JSONObject?,
                    response: GraphResponse?
                ) {
                    try {
                        uploadUserDataToRealtimeDB(
                            User(
//                                `object`!!.getString("id"),
//                                `object`.getString("name"),
//                                `object`.getString("email")
                            "","m","d"
                            )
                        )
                        Toast.makeText(
                            requireContext(),
                            "Upload Data Successesfully",
                            Toast.LENGTH_SHORT
                        ).show()

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

    fun uploadUserDataToRealtimeDB(user: User) {
        user.id = FirebaseAuth.getInstance().currentUser!!.uid
        FirebaseDatabase.getInstance().getReference("Users").child(
            FirebaseAuth.getInstance().currentUser!!.uid
        ).setValue(user).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("realtime", "success")
            } else {
                Log.d("realtime", "Failure")
            }
        }
    }
}
