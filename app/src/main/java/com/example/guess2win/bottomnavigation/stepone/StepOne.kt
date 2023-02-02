package com.example.guess2win.bottomnavigation.stepone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

import androidx.navigation.fragment.findNavController
import com.example.guess2win.IOnBackPressed
import com.example.guess2win.R
import com.example.guess2win.databinding.FragmentStepOneBinding


class StepOne : Fragment(), IOnBackPressed {
    lateinit var binding: FragmentStepOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStepOneBinding.inflate(inflater, container, false)
//        val navBuilder = NavOptions.Builder()
////
//        navBuilder.setEnterAnim(R.anim.slide_anim_in_right).setExitAnim(R.anim.slide_anim_out_left)
//            .setPopEnterAnim(R.anim.slide_anim_in_left).setPopExitAnim(R.anim.slide_anim_out_right)
        binding.buttonContinue.setOnClickListener {
//           ().navigate(R.id.stepTwo)

//            NavHostFragment.findNavController(this)
//                .navigate(R.id.stepTwo, null, navBuilder.build());
            val action = StepOneDirections.actionStepOneToStepTwo()
            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onBackPressed(): Boolean {
        return false
    }


}