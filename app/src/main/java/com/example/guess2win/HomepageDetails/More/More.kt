package com.example.guess2win.HomepageDetails.More

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.guess2win.R
import com.example.guess2win.databinding.FragmentMoreBinding
import com.google.firebase.auth.FirebaseAuth

class More : Fragment() {
    lateinit var binding: FragmentMoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        moreTransactions()
        return binding.root
    }

    private fun moreTransactions() {

        binding.prizeMore.setOnClickListener {
            findNavController().navigate(R.id.prize)
        }
        binding.profileMore.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }
        binding.helpMore.setOnClickListener {
            findNavController().navigate(R.id.helpFragment)
        }
        binding.callusMore.setOnClickListener {
            findNavController().navigate(R.id.callUsFragment)
        }

        binding.settingsMore.setOnClickListener {
            findNavController().navigate(R.id.settingsFragment)
        }

        binding.signoutMore.setOnClickListener {
            editPhoneDiallog()
        }


    }


    private fun editPhoneDiallog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.signout_dialog)
        dialog.setCancelable(false)
        dialog.findViewById<View>(R.id.signout_dialig).setOnClickListener {
            signOut()
            dialog.dismiss()
        }
        dialog.findViewById<View>(R.id.cansel_signout_dialog).setOnClickListener {
            dialog.dismiss()

        }
        dialog.show()
    }

    private fun signOut() {
        FirebaseAuth.getInstance().signOut()
        findNavController().navigate(R.id.logIn)
        Toast.makeText(requireContext(), "تم تسجيل الخروج", Toast.LENGTH_SHORT).show()
    }

}