package com.example.booking.fragments

import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.booking.R
import java.util.*
import kotlin.concurrent.schedule


class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash_screen, container, false)
       //timer to switch fragments
        Timer("Test", false).schedule(1000) {
            requireActivity().runOnUiThread {
                findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
            }
        }

        return view
    }


}