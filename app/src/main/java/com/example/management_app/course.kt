package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentCourseBinding

// TODO: Rename parameter arguments, choose names that match

class course : Fragment() {
    private lateinit var binding: FragmentCourseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCourseBinding.inflate(inflater, container, false)

        binding.homecourse.setOnClickListener {
            findNavController().navigate(R.id.action_course2_to_home2)
        }
        binding.cite.setOnClickListener {
            findNavController().navigate(R.id.action_course2_to_cite2)
        }
        binding.computereng.setOnClickListener {
            findNavController().navigate(R.id.action_course2_to_computereng2)
        }
        binding.tourism.setOnClickListener {
            findNavController().navigate(R.id.action_course2_to_tourism2)
        }
        return binding.root
    }


}