package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentProgramsBinding

class programs : Fragment() {

    private lateinit var binding: FragmentProgramsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProgramsBinding.inflate(inflater, container, false)

        binding.homee.setOnClickListener {
            findNavController().navigate(R.id.action_programs2_to_home2)
        }

        binding.radlearning.setOnClickListener {
            findNavController().navigate(R.id.action_programs2_to_radlearning)
        }
        binding.flexlearning.setOnClickListener {
            findNavController().navigate(R.id.action_programs2_to_flexlearning)
        }
        return binding.root

    }
}