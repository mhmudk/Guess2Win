package com.example.guess2win.bottomnavigation.steptwo

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.guess2win.IOnBackPressed
import com.example.guess2win.R
import com.example.guess2win.databinding.FragmentStepTwoBinding


class StepTwo : Fragment(),IOnBackPressed{
lateinit var binding: FragmentStepTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

binding = FragmentStepTwoBinding.inflate(inflater, container, false)
        val animation = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
      //  val navBuilder = NavOptions.Builder()
//
//        navBuilder.setEnterAnim(R.anim.slide_in_left).setExitAnim(R.anim.slide_out_right)
//            .setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right)
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
        binding.buttonShare.setOnClickListener {
            findNavController().navigate(R.id.logIn)
        }


        return binding.root
    }

    override fun onBackPressed(): Boolean {
        return false
    }

}