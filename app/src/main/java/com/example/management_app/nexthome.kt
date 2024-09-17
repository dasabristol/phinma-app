package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentNexthomeBinding

class nexthome : Fragment() {

    private lateinit var binding: FragmentNexthomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNexthomeBinding.inflate(inflater,container,false)

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_nexthome_to_home2)
        }
        binding.eventcalendarbtn.setOnClickListener {
            findNavController().navigate(R.id.action_nexthome_to_eventCalendar)
        }
        binding.handbookbtn.setOnClickListener {
            findNavController().navigate(R.id.action_nexthome_to_studenthandbook)
        }
        return binding.root
    }


}