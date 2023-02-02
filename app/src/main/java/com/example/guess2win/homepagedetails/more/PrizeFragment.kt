package com.example.guess2win.homepagedetails.more

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guess2win.ui.adapters.PrizesAdapter
import com.example.guess2win.data.model.Prize
import com.example.guess2win.R
import com.example.guess2win.databinding.FragmentPrizeBinding

class PrizeFragment : Fragment() {

    val adapter = PrizesAdapter()

    lateinit var binding: FragmentPrizeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrizeBinding.inflate(inflater, container, false)
        val items = mutableListOf(
            Prize("Item A", "تي شيرت رياضي رجالي", "1", "3", ""),
            Prize("Item A", "500 حنيه", "5", "4", ""),
            Prize("Item A", "سوني بلاي ستيشن 4", "22", "10", ""),
            Prize("Item A", "تي شيرت رياضي رجالي", "1", "3", ""),
            Prize("Item A", "500 حنيه", "5", "4", ""),
            Prize("Item A", "سوني بلاي ستيشن 4", "22", "10", ""),

            )
        sentDataToAdapter(items)
        getMatchIdFromAdapter()
        return binding.root
    }

    private fun getMatchIdFromAdapter() {
        adapter.setOnItemClick(object : PrizesAdapter.SentDetails {
            override fun onItemClick(postion: String) {
                findNavController().navigate(R.id.anticiptions)
            }

        })
    }

    fun sentDataToAdapter(listmovie: List<Prize>) {
        binding.recyclerViewPrize.layoutManager = LinearLayoutManager(requireContext())
        adapter.setList(listmovie)
        binding.recyclerViewPrize.adapter = adapter
    }
}