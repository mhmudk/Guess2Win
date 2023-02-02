package com.example.guess2win.bottomnavigation.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.guess2win.IOnBackPressed
import com.example.guess2win.R
import com.example.guess2win.databinding.FragmentLoginBinding
import com.example.guess2win.domain.Users.Google.Authentication
import com.example.guess2win.showToast
import com.example.guess2win.utils.SharedPref
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*


class LogIn : Fragment(), IOnBackPressed {
    lateinit var mAuth: FirebaseAuth
    lateinit var googleSignInClient: GoogleSignInClient
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

        loginViewmodel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[LoginViewModel::class.java]

        callbackManager = CallbackManager.Factory.create();
        initGoogleSignIn()
        LoginManager.getInstance().registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onCancel() {
                }

                override fun onError(error: FacebookException) {
                    Log.d("Error", "Error in" + error.message.toString())
                }

                override fun onSuccess(result: LoginResult) {
                    Toast.makeText(requireContext(), "Successsfuly", Toast.LENGTH_LONG).show()

                    findNavController().navigate(R.id.action_logIn_to_homepage)
                }

            })

        setEvents()

        lifecycleScope.launch {
            loginViewmodel.loginGoogleByStateFlow.collectLatest {
                SharedPref.setusertoken(it.token)
                SharedPref.setUserID(it.user.id)
                Log.d("Token is ", SharedPref.getusertoken())
                Log.d("User ID  is ", SharedPref.getUserID())

            }
        }


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
                val authModel =
                    Authentication(account.id!!, "", account.displayName.toString(), "01016292039")
                Log.d("cliendidtoserver:", account.id!!)

                loginViewmodel.getResponseGoogleUser(authModel)


                navigate()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error" + e.message.toString(), Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

    private fun navigate() {

        findNavController().navigate(R.id.homepage)
    }

    override fun onBackPressed(): Boolean {
        return false
    }

}