package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentScholarshipBinding

class scholarship : Fragment() {

    private lateinit var binding: FragmentScholarshipBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScholarshipBinding.inflate(inflater, container,false)

        binding.homescholar.setOnClickListener {
            findNavController().navigate(R.id.action_scholarship2_to_home2)
        }
        binding.hka.setOnClickListener {
            findNavController().navigate(R.id.action_scholarship2_to_hka2)
        }
        binding.hkb.setOnClickListener {
            findNavController().navigate(R.id.action_scholarship2_to_hkb2)
        }
        binding.hkc.setOnClickListener {
            findNavController().navigate(R.id.action_scholarship2_to_hkc2)
        }
        binding.hkd.setOnClickListener {
            findNavController().navigate(R.id.action_scholarship2_to_hkd2)
        }
        return binding.root
    }


}