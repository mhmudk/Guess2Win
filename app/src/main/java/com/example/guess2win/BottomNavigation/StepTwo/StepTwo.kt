package com.example.guess2win.BottomNavigation.StepTwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.guess2win.R
import com.example.guess2win.databinding.FragmentStepTwoBinding

class StepTwo : Fragment() {
lateinit var binding: FragmentStepTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

binding = FragmentStepTwoBinding.inflate(inflater, container, false)

        binding.buttonShare.setOnClickListener {
            findNavController().navigate(R.id.logIn)
        }


        return binding.root
    }

}