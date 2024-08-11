package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentRadlearningBinding
private lateinit var binding : FragmentRadlearningBinding
class radlearning : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadlearningBinding.inflate(inflater, container, false)

        binding.radbutton.setOnClickListener {
            findNavController().navigate(R.id.action_radlearning_to_programs2)
        }
        return binding.root

    }
}