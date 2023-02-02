package com.example.guess2win

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.guess2win.databinding.FragmentSplachScreenBinding
import com.example.guess2win.utils.SharedPref


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
        if (SharedPref.getusertoken().isNullOrBlank()) {
          findNavController().navigate(R.id.action_splachScreen_to_stepOne)
        } else {
            findNavController().navigate(R.id.action_splachScreen_to_homepage)
        }

        return binding.root
    }

}