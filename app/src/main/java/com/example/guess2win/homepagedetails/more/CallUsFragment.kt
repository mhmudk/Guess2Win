package com.example.guess2win.homepagedetails.more

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.guess2win.databinding.FragmentCallUsBinding


class CallUsFragment : Fragment() {
lateinit var binding:FragmentCallUsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding  = FragmentCallUsBinding.inflate(inflater, container, false)

        setEvents()
        return binding.root
    }
    private fun setEvents(){
        binding.intentToFacebookPage.setOnClickListener {
            intentToFacebookPage()
        }
    }
private fun intentToFacebookPage(){
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100075787785800&mibextid=ZbWKwL"))
        startActivity(intent)
    } catch (e: Exception) {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://www.facebook.com/appetizerandroid")
            )
        )
    }
}

}