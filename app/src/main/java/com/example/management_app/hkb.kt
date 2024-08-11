package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentHkbBinding

class hkb : Fragment() {

    private lateinit var binding: FragmentHkbBinding
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHkbBinding.inflate(inflater, container, false)
        binding.hkbbtn.setOnClickListener {
            findNavController().navigate(R.id.action_hkb2_to_scholarship2)
        }
        return binding.root
    }


}