package com.example.management_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentFacetofaceBinding

class facetoface : Fragment() {

    private lateinit var binding: FragmentFacetofaceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFacetofaceBinding.inflate(inflater, container, false)

        binding.facetofacebutton.setOnClickListener {
            findNavController().navigate(R.id.action_facetoface_to_programs2)
        }
        return binding.root
    }

}