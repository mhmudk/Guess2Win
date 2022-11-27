package com.example.guess2win.BottomNavigation.StepOne

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.guess2win.R
import com.example.guess2win.databinding.FragmentStepOneBinding


class StepOne : Fragment() {
 lateinit var binding  :FragmentStepOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentStepOneBinding.inflate(inflater , container, false)

binding.buttonContinue.setOnClickListener {
    findNavController().navigate(R.id.stepTwo)
}

        return binding.root
    }


}