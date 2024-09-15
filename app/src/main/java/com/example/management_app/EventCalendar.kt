package com.example.management_app

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentEventCalendarBinding
import java.text.SimpleDateFormat
import java.util.*

class EventCalendar : Fragment() {

    private var _binding: FragmentEventCalendarBinding? = null
    private val binding get() = _binding!!

    // A map to store events for specific dates
    private val eventsMap = mutableMapOf<String, List<String>>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize view binding
        _binding = FragmentEventCalendarBinding.inflate(inflater, container, false)

        // Navigation: Set up back button to navigate to another fragment
        binding.calendarbackbtn.setOnClickListener {
            findNavController().navigate(R.id.action_eventCalendar_to_nexthome)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Format dates in dd-MM-yyyy format
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

        // Add events for specific dates (September 19, 20, and 21)
        eventsMap["19-09-2024"] = listOf("KOMSAYAHAN", "1ST DAY")
        eventsMap["20-09-2024"] = listOf("KOMSAYAHAN", "2ND DAY")
        eventsMap["21-09-2024"] = listOf("KOMSAYAHAN", "LAST DAY")

        // Set listener for date changes in CalendarView
        binding.calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = String.format("%02d-%02d-%d", dayOfMonth, month + 1, year)
            showEventDialog(selectedDate)
        }
    }

    private fun showEventDialog(date: String) {
        // Inflate the custom dialog view
        val dialogView = layoutInflater.inflate(R.layout.dialog_event, null)
        val eventListView: ListView = dialogView.findViewById(R.id.eventListView)
        val dialogTitle: TextView = dialogView.findViewById(R.id.dialogTitle)

        // Set the title to the selected date
        dialogTitle.text = "Events on $date"

        // Get events for the selected date, or display "No events" if none exist
        val events = eventsMap[date] ?: listOf("No events")

        // Populate the ListView with the events
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, events)
        eventListView.adapter = adapter

        // Show the dialog with the events
        AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setPositiveButton("OK", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
