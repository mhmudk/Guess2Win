package com.example.guess2win.homepagedetails

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guess2win.ui.adapters.RankingAdapter
import com.example.guess2win.IOnBackPressed
import com.example.guess2win.data.model.PlayersRanking
import com.example.guess2win.databinding.FragmentRatingBinding


class Rating : Fragment(), AdapterView.OnItemSelectedListener, IOnBackPressed {
    lateinit var binding: FragmentRatingBinding
    private val adapter= RankingAdapter()
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
        weekSpinnersSelections()
        monthSpinnersSelections()
        yearSpinnersSelections()
        val items = mutableListOf(
            PlayersRanking("Item A", "Dr Atia khattab",  5),
            PlayersRanking("Item A", "House Keeping Reda ",  5),
            PlayersRanking("Item A", "Eng Nabwia ", 4),
            PlayersRanking("Item A", "Teacher Asmaa",  3),
            PlayersRanking("Item A", "Dr Alshefaa", 25),
            PlayersRanking("Item A", "Eng Mahmoud", 25)
        )
        sentDataToAdapter(items)
        getMatchIdFromAdapter()
        return binding.root
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Toast.makeText(requireContext(), weekOfDays[p2], Toast.LENGTH_LONG).show();
        Toast.makeText(requireContext(), monthOfDays[p2], Toast.LENGTH_LONG).show();
        Toast.makeText(requireContext(), yearOfDays[p2], Toast.LENGTH_LONG).show();
    }
    private fun getMatchIdFromAdapter() {
        adapter.setOnItemClick(object : RankingAdapter.SentDetails {
            override fun onItemClick(postion: String) {
                findNavController().navigate(com.example.guess2win.R.id.anticiptions)
            }

        })
    }

    fun sentDataToAdapter(listmovie: List<PlayersRanking>) {
        binding.recRating.layoutManager = LinearLayoutManager(requireContext())
        adapter.setList(listmovie)
        binding.recRating.adapter = adapter
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onBackPressed(): Boolean {
        return false
    }

    private fun weekSpinnersSelections() {
        binding.spinnerWeek.onItemSelectedListener = this
        val adapterSpinner: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireContext(), R.layout.simple_spinner_item, weekOfDays)
        adapterSpinner.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinnerWeek.adapter = adapterSpinner;
    }
    private fun monthSpinnersSelections() {
        binding.spinnerMonth.onItemSelectedListener = this
        val adapterSpinner: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireContext(), R.layout.simple_spinner_item, monthOfDays)
        adapterSpinner.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinnerMonth.adapter = adapterSpinner;
    }
    private fun yearSpinnersSelections() {
        binding.spinnerYear.onItemSelectedListener = this
        val adapterSpinner: ArrayAdapter<*> =
            ArrayAdapter<Any?>(requireContext(), R.layout.simple_spinner_item, yearOfDays)
        adapterSpinner.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinnerYear.adapter = adapterSpinner;
    }


}