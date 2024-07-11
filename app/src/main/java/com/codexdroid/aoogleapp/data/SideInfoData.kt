package com.codexdroid.aoogleapp.data

data class ClickTextData(
    val id : Int,
    val title: String,
    val url: String?,
)
val techStackDataLinks = listOf<ClickTextData>(
    ClickTextData(0,"Tech Stack: ", ""),
    ClickTextData(1,"Android, ","https://developer.android.com"),
    ClickTextData(2,"Kotlin, ","https://kotlinlang.org/"),
    ClickTextData(3,"Ktor, ","https://ktor.io/"),
    ClickTextData(4,"Jetpack Compose, ","https://developer.android.com/develop/ui/compose"),
    ClickTextData(5,"XML, ","https://en.wikipedia.org/wiki/XML"),
    ClickTextData(5,"DSA, ","https://techdevguide.withgoogle.com/paths/data-structures-and-algorithms/"),
)

val techStackData = listOf<ClickTextData>(
    ClickTextData(1,"Firebase, ",null),
    ClickTextData(2,"RestAPI, ",null),
    ClickTextData(3,"MySQL, ",null),
)

//-----------------------------------------------------
val androidAppsLinks = listOf<ClickTextData>(
    ClickTextData(0,"Android Apps: ",""),
    ClickTextData(1,"Glasswing Partner, ","https://play.google.com/store/apps/details?id=in.glasswing.partner"),
    ClickTextData(1,"SKy Recharge, ","https://play.google.com/store/apps/details?id=com.skyonlinerechargeservices"),
    ClickTextData(1,"ERxPharmaPro, ","https://play.google.com/store/apps/details?id=com.svsion.erxpharma"),
    ClickTextData(1,"M3 Compose, ","https://play.google.com/store/apps/details?id=com.codexdroid.m3compose"),
)

val androidApps = listOf<ClickTextData>(
    ClickTextData(1,"Project Mamta, ",null),
    ClickTextData(2,"Parrot4Business, ",null),
    ClickTextData(3,"CreditHive POS",null),
)

//------------------------------------------------------

val areasWorkedOn = listOf(
    "Area worked on: ",
    "Goods Delivery, ",
    "Food and Drink, ",
    "Food Delivery, ",
    "Health, Finance, ",
    "Medical, Educational"
)

val interest = listOf(
    "Interest: ",
    "Music, ",
    "Coding, ",
    "Driving, ",
    "Gaming, ",
    "Travelling, ",
    "Shopping",

    )



