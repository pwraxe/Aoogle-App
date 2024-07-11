package com.codexdroid.aoogleapp.utils

import java.time.LocalDate
import java.time.Month
import java.time.Period

//Ref: https://github.com/Kotlin/kotlinx-datetime?tab=readme-ov-file

enum class PAGE {
    HOME, SEARCH
}


private fun getTotalMonths(): Int {

    val startDate = LocalDate.of(2019, Month.JULY, 19)
    val presentDate = LocalDate.now()
    return Period.between(startDate, presentDate).toTotalMonths().toInt()

//    val currentTime = Clock.System.now().toLocalDateTime(TimeZone.UTC)
//    val start = LocalDate.parse("2019-07-19")
//
//    val month = currentTime.month.number
//
//    val end = LocalDate.parse("${currentTime.year}-${if (month in 1 .. 9) "0$month" else month}-${currentTime.dayOfMonth}")
//
//    return start.monthsUntil(end)
//
//    return 60  //till from July 2019 --> July-2024
}

fun getTotalExperience(): String {
    val totalMonths = getTotalMonths()
    return "${totalMonths / 12} years and ${totalMonths % 12} Months"
}

fun getActualExperience(): Double {
    return getTotalMonths().div(12) - getFreelanceExperience()
}

fun getFreelanceExperience(): Double {
    return 0.8
}

fun getAge(): Int {
    return LocalDate.now().year - 1996
}