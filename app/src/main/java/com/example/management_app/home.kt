package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentHomeBinding

class home : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        //code here
        binding.profile.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_profile)
        }

        binding.programs.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_programs2)
        }
        binding.scholarship.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_scholarship2)
        }
        binding.aboutus.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_aboutus2)
        }
        binding.course.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_course2)
        }


        return binding.root
    }


}