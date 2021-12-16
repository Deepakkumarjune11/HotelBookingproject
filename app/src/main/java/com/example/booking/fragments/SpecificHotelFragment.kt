package com.example.booking.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.booking.BookingApp
import com.example.booking.MainActivity
import com.example.booking.R
import com.example.booking.data.BookingDatabase
import com.example.booking.data.ReservationMin
import com.example.booking.data.UserMin
import com.example.booking.databinding.FragmentLoginBinding
import com.example.booking.databinding.FragmentSpecificHotelBinding
import com.example.booking.viewmodels.HotelViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpecificHotelFragment : Fragment() {

    private val args by navArgs<SpecificHotelFragmentArgs>()

    private var _binding: FragmentSpecificHotelBinding? = null
    private val binding get() = _binding!!
    private lateinit var mUserViewModel: HotelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpecificHotelBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        mUserViewModel = ViewModelProvider(this)[HotelViewModel::class.java]


//HtmlCompat.fromHtml("Price per room: <b> ${args.currentHotel.pricePerNight} <b>", HtmlCompat.FROM_HTML_MODE_LEGACY)
        (requireActivity() as MainActivity).supportActionBar?.title = args.currentHotel.name
        binding.reservedByPeople.text = "Already reserved by ${args.currentHotel.reservedByPeople} people"
        binding.pricePerRoom.text = HtmlCompat.fromHtml("Price per room: <b> ${args.currentHotel.pricePerNight}$ <b>", HtmlCompat.FROM_HTML_MODE_LEGACY)
        binding.roomLeft.text = HtmlCompat.fromHtml("Rooms left:<b> ${args.currentHotel.roomsLeft} <b>", HtmlCompat.FROM_HTML_MODE_LEGACY)
//        binding.localAttraction.text = "Rooms left: ${args.currentHotel.roomsLeft}"
//        binding.localAttractionDescription.text = "Rooms left: ${args.currentHotel.roomsLeft}"
        Picasso.get().load(args.currentHotel.url).into( binding.hotelPhoto)
//
        binding.hotelRowCustom.setOnClickListener { view ->
            val action = SpecificHotelFragmentDirections.actionSpecificHotelFragmentToCreateReservationFragment(args.currentHotel)
            Navigation.findNavController(view).navigate(action)
        }
//        binding.createReservation.setOnClickListener {
//            findNavController().navigate(R.id.action_specificHotelFragment_to_createReservationFragment)
////            createReservation(args.currentHotel.id, args.currentHotel.)
//        }
        setHasOptionsMenu(true)
        return binding.root
    }
//
//    private fun createReservation(hotelId: Int, count: Int) {
//        val myApplication = activity?.application as BookingApp
//        val httpApiService = myApplication.httpApiService
////        val dao = BookingDatabase.getInstance().bookingDao().
//        CoroutineScope(Dispatchers.IO).launch {
//
//            httpApiService.createReservation(ReservationMin(hotelId, count))
////
//            withContext(Dispatchers.Main){
//                Log.d("BookingDBString", "DB Filled")
//
//            }
//
//        }
//        TODO("Not yet implemented")
//    }
}

