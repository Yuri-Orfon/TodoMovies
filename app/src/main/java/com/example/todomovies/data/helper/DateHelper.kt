package com.example.todomovies.data.helper

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateHelper {
    fun dateFormat(date: String) : String {
        val locale = Locale("pt", "BR")
        return try {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", locale).parse(date?: "")
            SimpleDateFormat("yyyy", locale).format(dateFormat).capitalize()
        } catch (e: ParseException){
            ""
        }
    }
}