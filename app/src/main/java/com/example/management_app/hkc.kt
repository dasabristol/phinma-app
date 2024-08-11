package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentHkcBinding

class hkc : Fragment() {

    private lateinit var binding: FragmentHkcBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHkcBinding.inflate(inflater, container, false)

        binding.hkcbtn.setOnClickListener {
            findNavController().navigate(R.id.action_hkc2_to_scholarship2)
        }
        return binding.root
    }

}