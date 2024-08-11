package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentHkaBinding

class hka : Fragment() {
    private lateinit var binding: FragmentHkaBinding
    // TODO: Rename and change types of parameters
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHkaBinding.inflate(inflater, container, false)

        binding.hkabtn.setOnClickListener {
            findNavController().navigate(R.id.action_hka2_to_scholarship2)
        }
        return binding.root
    }


}