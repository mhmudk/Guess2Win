package com.example.guess2win.HomepageDetails

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.guess2win.IOnBackPressed
import com.example.guess2win.databinding.FragmentRatingBinding


class Rating : Fragment(), AdapterView.OnItemSelectedListener , IOnBackPressed {
    lateinit var binding: FragmentRatingBinding
    var weekOfDays = arrayOf("اسبوع 1", "الإسبوع 2", "الإسبوع 3")
    var monthOfDays = arrayOf("الشهر  1", "الشهر 2", "الشهر 3")
    var yearOfDays = arrayOf("1")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRatingBinding.inflate(inflater, container, false)
        binding.spinnerWeek.onItemSelectedListener = this
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.simple_spinner_item, weekOfDays)
        aa.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinnerWeek.setAdapter(aa);
        return binding.root
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Toast.makeText(requireContext(),weekOfDays[p2] , Toast.LENGTH_LONG).show();
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onBackPressed(): Boolean {
         return false
    }


}