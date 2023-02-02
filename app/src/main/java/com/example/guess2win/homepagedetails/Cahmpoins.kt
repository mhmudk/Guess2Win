package com.example.guess2win.homepagedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guess2win.ui.adapters.ChampionsAdapter
import com.example.guess2win.IOnBackPressed
import com.example.guess2win.data.model.Champions
import com.example.guess2win.R
import com.example.guess2win.databinding.FragmentCahmpoinsBinding


class Cahmpoins : Fragment(), IOnBackPressed {
    private val adapter= ChampionsAdapter()
    lateinit var binding: FragmentCahmpoinsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCahmpoinsBinding.inflate(inflater, container, false)
        val items = mutableListOf(
            Champions("Item A", "Egyption",  ""),
            Champions("Item A", "Bundeslega", ""),
            Champions("Item A", "Perimery league",  ""),
            Champions("Item A", "Laliga", "")
        )
        sentDataToAdapter(items)
        getMatchIdFromAdapter()
        return binding.root
    }
    private fun getMatchIdFromAdapter() {
        adapter.setOnItemClick(object : ChampionsAdapter.SentDetails {
            override fun onItemClick(postion: String) {
                findNavController().navigate(R.id.anticiptions)
            }

        })
    }

    fun sentDataToAdapter(listmovie: List<Champions>) {
        binding.recChampion.layoutManager = LinearLayoutManager(requireContext())
        adapter.setList(listmovie)
        binding.recChampion.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recChampion.adapter = adapter
    }

    override fun onBackPressed(): Boolean {
        return false
    }

}