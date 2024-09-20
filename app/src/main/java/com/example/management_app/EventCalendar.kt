package com.example.management_app

import android.app.AlarmManager
import android.app.AlertDialog
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.management_app.databinding.FragmentEventCalendarBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class EventCalendar : Fragment() {

    private var _binding: FragmentEventCalendarBinding? = null
    private val binding get() = _binding!!

    private val eventsMap = mutableMapOf<String, List<String>>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEventCalendarBinding.inflate(inflater, container, false)

        // Back button navigation
        binding.calendarbackbtn.setOnClickListener {
            findNavController().navigate(R.id.action_eventCalendar_to_home2)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Date formatter
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

        // Add events
        eventsMap["19-09-2024"] = listOf("KOMSAYAHAN - DAGUPAN 1st Day")
        eventsMap["20-09-2024"] = listOf("KOMSAYAHAN - DAGUPAN 2nd Day")
        eventsMap["21-09-2024"] = listOf("KOMSAYAHAN - DAGUPAN 3rd Day")
        eventsMap["05-12-2024"] = listOf("LAMPARAAN - UPANG U Atrium")
        eventsMap["09-12-2024"] = listOf("NINGNING PROJECT - AROUND URDANETA")
        eventsMap["12-12-2024"] = listOf("LINGAPWIKA COMMUNITY OUTREACH PROGRAM - LOCAL SCHOOL")
        eventsMap["03-01-2025"] = listOf("EUCHARISTIC CELEBRATION - UPANG U Atrium")
        eventsMap["09-01-2025"] = listOf("STRAND DAY - UPANG U Atrium")
        eventsMap["14-01-2025"] = listOf("SEMINAR FOR THE DSPC PARTICIPANTS - UPANG U Atrium")


        // CalendarView date change listener
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
        val timePicker: TimePicker = dialogView.findViewById(R.id.timePicker)

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
            .setPositiveButton("OK") { _, _ ->
                if (events.isNotEmpty() && events[0] != "No events") {
                    for (event in events) {
                        try {
                            val calendar = Calendar.getInstance().apply {
                                set(Calendar.YEAR, date.split("-")[2].toInt())
                                set(Calendar.MONTH, date.split("-")[1].toInt() - 1)
                                set(Calendar.DAY_OF_MONTH, date.split("-")[0].toInt())
                                set(Calendar.HOUR_OF_DAY, timePicker.hour)
                                set(Calendar.MINUTE, timePicker.minute)
                                set(Calendar.SECOND, 0)
                                set(Calendar.MILLISECOND, 0)
                            }

                            scheduleReminder(event, calendar.timeInMillis)
                        } catch (e: Exception) {
                            Log.e("EventCalendar", "Failed to schedule reminder: ${e.message}")
                        }
                    }
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun scheduleReminder(eventTitle: String, eventTimeInMillis: Long) {
        val alarmManager = requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(requireContext(), ReminderReceiver::class.java).apply {
            putExtra("eventTitle", eventTitle)
        }
        val pendingIntent = PendingIntent.getBroadcast(
            requireContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Schedule the alarm for the event
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, eventTimeInMillis, pendingIntent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
