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
import com.example.management_app.databinding.FragmentEditprofileBinding

class editprofile : Fragment() {

    private lateinit var binding: FragmentEditprofileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEditprofileBinding.inflate(inflater, container, false)

        setupSpinners()

        binding.editsave.setOnClickListener {
            findNavController().navigate(R.id.action_editprofile_to_profile)
        }
        return binding.root
    }

    private fun setupSpinners() {
        // Setup Gender Spinner
        val genderAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.gender_array,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        binding.spinnerGender.adapter = genderAdapter

        // Setup School Spinner
        val schoolAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.school_array,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        binding.spinnerSchool.adapter = schoolAdapter

    }
}