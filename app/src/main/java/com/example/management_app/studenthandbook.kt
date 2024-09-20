package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentStudenthandbookBinding

class studenthandbook : Fragment() {

    private lateinit var binding: FragmentStudenthandbookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStudenthandbookBinding.inflate(inflater, container, false)

        binding.handbookbtn.setOnClickListener {
            findNavController().navigate(R.id.action_studenthandbook_to_home2)
        }
        return binding.root
    }


}