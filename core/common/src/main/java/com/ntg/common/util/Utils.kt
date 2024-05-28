package com.ntg.common.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun formatDate(date: Date): String {
    val dateFormat = SimpleDateFormat("MMMM d yyyy", Locale.getDefault())
    return dateFormat.format(date)
}

fun getCurrentTime12Hour(): String {
    val calendar = Calendar.getInstance()
    val timeFormat = SimpleDateFormat("hh:mm a")
    return timeFormat.format(calendar.time)
}

fun getCurrentTime(): String {
    val calendar = Calendar.getInstance()
    val timeFormat = SimpleDateFormat("HH:mm")
    return timeFormat.format(calendar.time)
}