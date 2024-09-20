package com.example.management_app

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentHomeBinding

class home : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Set up navigation for other buttons
        binding.profile.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_profile)
        }

        binding.programs.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_programs2)
        }
        binding.scholarship.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_scholarship2)
        }
        binding.aboutus.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_aboutus2)
        }
        binding.course.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_course2)
        }
        binding.maps.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_map)
        }
        binding.eventcalendarbtn.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_eventCalendar)
        }

        // Handle student handbook button click with a dialog
        binding.studenthandbookbtn.setOnClickListener {
            showStudentHandbookDialog()
        }

        return binding.root
    }

    private fun showStudentHandbookDialog() {
        // Inflate the dialog layout
        val dialogView = LayoutInflater.from(context).inflate(R.layout.student_handbook_dialog, null)

        // Create the dialog using AlertDialog.Builder
        val dialogBuilder = AlertDialog.Builder(context)
            .setView(dialogView)
            .create()

        // Set up the close button inside the dialog
        val closeButton: Button = dialogView.findViewById(R.id.closeDialogButton)
        closeButton.setOnClickListener {
            dialogBuilder.dismiss() // Close the dialog when the button is clicked
        }

        // Show the dialog
        dialogBuilder.show()
    }
}
