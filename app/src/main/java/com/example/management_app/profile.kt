package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentProfileBinding


class profile : Fragment() {
private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.save.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_home2)
        }
        binding.editprofile.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_editprofile)
        }
        return binding.root
    }


}
