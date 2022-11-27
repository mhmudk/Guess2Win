package com.example.guess2win.HomepageDetails.MatchesandAnticiptions


import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guess2win.Adapters.MatchesAdapter
import com.example.guess2win.IOnBackPressed
import com.example.guess2win.Model.Match
import com.example.guess2win.R
import com.example.guess2win.databinding.FragmentMatchesBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class Matches : Fragment(),IOnBackPressed {

    val adapter: MatchesAdapter = MatchesAdapter()

    lateinit var binding: FragmentMatchesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchesBinding.inflate(inflater, container, false)

        val items = mutableListOf(
            Match("Item A", "Liverpool", "ManCity", "", ""),
            Match("Item A", "Ahly", "Zamalek", "", ""),
            Match("Item A", "Egypt", "Senegal", "", ""),

            )

        sentDataToAdapter(items)
        getMatchIdFromAdapter()
        setEvents()
        return binding.root
    }

    private fun setEvents() {
        binding.calenderId.setOnClickListener {
            getDateFromPickerCalender()


        }
    }

    private fun getMatchIdFromAdapter() {
        adapter.setOnItemClick(object : MatchesAdapter.SentDetails {
            override fun onItemClick(postion: String) {
                findNavController().navigate(R.id.anticiptions)
            }

        })
    }

    fun sentDataToAdapter(listmovie: List<Match>) {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setList(listmovie)
        binding.recyclerView.adapter = adapter
    }

    private fun getDateFromPickerCalender() {

        var datee: Calendar = Calendar.getInstance()
        var thisAYear = datee.get(Calendar.YEAR).toInt()
        var thisAMonth = datee.get(Calendar.MONTH).toInt()
        var thisADay = datee.get(Calendar.DAY_OF_MONTH).toInt()
        val local = Locale("en", "ID")
        val simpledate = SimpleDateFormat("dd/MM/yyyy", local)

        val dpd = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view2, thisYear, thisMonth, thisDay ->
            thisAMonth = thisMonth + 1
            thisADay = thisDay
            thisAYear = thisYear

            binding.dateNow.text="Date: " +thisDay + "/" +  thisAMonth + "/" + thisYear
            val newDate:Calendar =Calendar.getInstance()
            newDate.set(thisYear, thisMonth, thisDay)

        }, thisAYear, thisAMonth, thisADay)
        dpd.show()

        dpd.setTitle("Select Date")
        dpd.show()


    }

    override fun onBackPressed(): Boolean {
        return false
    }


}