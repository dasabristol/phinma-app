package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentCiteBinding

class cite : Fragment() {
   private lateinit var binding: FragmentCiteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentCiteBinding.inflate(inflater, container, false)

        binding.citebtn.setOnClickListener {
            findNavController().navigate(R.id.action_cite2_to_course2)
        }
        return binding.root
    }


}