package com.example.guess2win.HomepageDetails.MatchesandAnticiptions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guess2win.R
import com.example.guess2win.databinding.FragmentAnticiptionsBinding

class Anticiptions : Fragment() {
  lateinit var binding:FragmentAnticiptionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding = FragmentAnticiptionsBinding.inflate(inflater, container, false)

        return binding.root
    }

}