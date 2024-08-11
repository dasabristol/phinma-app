package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentHkdBinding

class hkd : Fragment() {

    private lateinit var binding: FragmentHkdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHkdBinding.inflate(inflater, container, false)

        binding.hkdbtn.setOnClickListener {
            findNavController().navigate(R.id.action_hkd2_to_scholarship2)
        }
        return binding.root
    }


}