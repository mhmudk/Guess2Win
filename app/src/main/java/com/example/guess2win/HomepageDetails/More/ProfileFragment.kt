package com.example.guess2win.HomepageDetails.More

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.guess2win.R
import com.example.guess2win.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        setEvents()
        return binding.root
    }

    private fun setEvents() {
        binding.editPhoneProfile.setOnClickListener {

            editPhoneDiallog()
        }
    }


    private fun editPhoneDiallog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.profile_phone_dialog)
        dialog.setCancelable(false)
        //val canselButton = dialog.findViewById<Button>(R.id.cansel_btn)
        val newNumber = dialog.findViewById<EditText>(R.id.profile_number)
        dialog.findViewById<View>(R.id.cansel_btn).setOnClickListener {
            dialog.cancel()
        }
        dialog.findViewById<View>(R.id.save_phone_profile).setOnClickListener {
            var newnumber_user = newNumber?.text.toString()
            if(newnumber_user.isEmpty()){
                Toast.makeText(requireContext(),"Please Fill field",Toast.LENGTH_SHORT).show()
            }else{
                binding.profileNumberProfile.text = newnumber_user
                dialog.dismiss()
            }
        }
        dialog.show()
    }
}