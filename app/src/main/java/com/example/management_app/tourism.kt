package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentTourismBinding

class tourism : Fragment() {
    private lateinit var binding: FragmentTourismBinding
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTourismBinding.inflate(inflater, container, false)

        binding.tourismbtn.setOnClickListener {
            findNavController().navigate(R.id.action_tourism2_to_course2)
        }
        return binding.root
    }


}