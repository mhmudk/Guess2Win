package com.example.guess2win.BottomNavigation.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.guess2win.Model.User
import com.example.guess2win.R
import com.example.guess2win.databinding.FragmentLoginBinding
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.util.*


class LogIn : Fragment() {
    lateinit var mAuth: FirebaseAuth
    lateinit var googleSignInClient: GoogleSignInClient
    var googleAccount: GoogleSignInAccount? = null
    lateinit var loginViewmodel: LoginViewModel

    lateinit var binding: FragmentLoginBinding
    lateinit var callbackManager: CallbackManager
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        FacebookSdk.sdkInitialize(requireContext());


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        mAuth = FirebaseAuth.getInstance();
        loginViewmodel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(LoginViewModel::class.java)
        callbackManager = CallbackManager.Factory.create();
        initGoogleSignIn()
        LoginManager.getInstance().registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onCancel() {
                }

                override fun onError(error: FacebookException) {
                    Toast.makeText(
                        requireContext(),
                        "Error${error.message.toString()}",
                        Toast.LENGTH_LONG
                    ).show()
                    Log.d("Error", "Error in" + error.message.toString())
                }

                override fun onSuccess(result: LoginResult) {
                    Toast.makeText(requireContext(), "Successsfuly", Toast.LENGTH_LONG).show()
                    handleFacebookAccessToken(result.accessToken);
                    findNavController().navigate(R.id.action_logIn_to_homepage)


                }

            })
        setEvents()
        return binding.root
    }

    private fun setEvents() {
        binding.buttonGoogle.setOnClickListener {
            signin()
        }
        binding.buttonFacebook.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(
                this,
                Arrays.asList("email", "public_profile", "user_friends")
            );
        }
    }


    private fun initGoogleSignIn() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.google_cline))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

    }

    private fun handleFacebookAccessToken(token: AccessToken) {

        val credential = FacebookAuthProvider.getCredential(token.token)
        FirebaseAuth.getInstance().signInWithCredential(credential).addOnSuccessListener {

        }.addOnFailureListener {
            Log.d("error", "Error creating account : " + it.message)
            Toast.makeText(requireContext(), "" + it.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun signin() {
        val signinintent = googleSignInClient.signInIntent
        startActivityForResult(signinintent, 1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1000) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account)
                navigate()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error" + e.message.toString(), Toast.LENGTH_SHORT)
                    .show()
            }

            Toast.makeText(
                requireContext(),
                "Account name" + googleAccount?.displayName,
                Toast.LENGTH_SHORT
            ).show()


        }
    }

    private fun navigate() {

        findNavController().navigate(R.id.homepage)
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val auth = GoogleAuthProvider.getCredential(acct.idToken, null)
        FirebaseAuth.getInstance().signInWithCredential(auth).addOnSuccessListener {
            val user = User(acct.id.toString(), acct.displayName.toString(), acct.email.toString())
            loginViewmodel.uploadUserDataToRealtime(user)

        }.addOnFailureListener {
            Log.d("error", "Error creating account : " + it.message)
            Toast.makeText(requireContext(), "" + it.message, Toast.LENGTH_SHORT).show()
        }
    }


}