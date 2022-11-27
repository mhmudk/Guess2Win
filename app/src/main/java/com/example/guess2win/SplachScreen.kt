package com.example.guess2win

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.guess2win.databinding.FragmentSplachScreenBinding
import com.google.firebase.auth.FirebaseAuth


class SplachScreen : Fragment() {

    lateinit var binding: FragmentSplachScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplachScreenBinding.inflate(inflater, container, false)
        val user = FirebaseAuth.getInstance().currentUser
        if (user == null) {
          findNavController().navigate(R.id.action_splachScreen_to_logIn)
        } else {
            findNavController().navigate(R.id.action_splachScreen_to_homepage)

        }

        return binding.root
    }

}