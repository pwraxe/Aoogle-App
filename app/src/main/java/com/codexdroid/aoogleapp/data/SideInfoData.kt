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
    ClickTextData(6,"DSA, ","https://techdevguide.withgoogle.com/paths/data-structures-and-algorithms/"),
)

val techStackData = listOf<ClickTextData>(
    ClickTextData(1,"Firebase, ",null),
    ClickTextData(2,"RestAPI, ",null),
    ClickTextData(3,"MySQL, ",null),
    ClickTextData(4,"FCM, ",null),
    ClickTextData(5,"Postman, ",null),
    ClickTextData(6,"KMM, ",null),
    ClickTextData(7,"AndroidX, ",null),
    ClickTextData(8,"Jetpack Library, ",  null),
    ClickTextData(9,"Jetpack Components, ", null)
)

//-----------------------------------------------------
val androidAppsLinks = listOf<ClickTextData>(
    ClickTextData(0,"Android Apps: ",""),
    ClickTextData(1,"M3 Compose, ","https://play.google.com/store/apps/details?id=com.codexdroid.m3compose"),
    ClickTextData(2,"Aoogle App, ","https://play.google.com/store/apps/details?id=com.codexdroid.aoogleapp"),
    ClickTextData(3,"ERxPharmaPro, ","https://play.google.com/store/apps/details?id=com.svsion.erxpharma"),
    ClickTextData(4,"SKy Recharge, ","https://play.google.com/store/apps/details?id=com.skyonlinerechargeservices"),
    ClickTextData(5,"Kichenbaba, ","https://play.google.com/store/apps/developer?id=Arcelor+Technology+Private+Limited"),
    ClickTextData(6,"Glasswing Partner, ","https://play.google.com/store/apps/details?id=in.glasswing.partner"),
    ClickTextData(7,"TE Project, ","https://github.com/pwraxe/Android-TE-Project"),
    ClickTextData(8,"Collage Bonafide, ","https://github.com/pwraxe/Android-CollegeBonafide"),

)

val androidApps = listOf<ClickTextData>(
    ClickTextData(1,"Project Mamta, ",null),
    ClickTextData(2,"Project Boss, ",null),
    ClickTextData(3,"Parrot4Business, ",null),
    ClickTextData(4,"CreditHive POS, ",null),
    ClickTextData(5,"Grampanchayat, ",null),
    ClickTextData(6,"POS App",null),
    ClickTextData(7,"Store App",null),
    ClickTextData(8,"E-KYC",null),
    ClickTextData(9,"MDM-3",null),
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



