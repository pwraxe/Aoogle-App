package com.codexdroid.aoogleapp.data

import com.codexdroid.aoogleapp.R

data class PageAllItemData(
    val image: Int,
    val heading: String,
    val url: String,
    val title: String,
    val desc: String,
    val duration: String,
    val isFullTime: Boolean,
    val location: String,
    val extraStr: String = "",
    val isUrlSafe: Boolean = true
)

val pageAllMainData = listOf(

    PageAllItemData(
        image = R.drawable.logo_mobile_llc,
        heading = "Mobile LLC",
        url = "https://www.programming.com/",
        title = "Mobile Programming India Pvt. Ltd.",
        desc = "Our mission is to use advanced technology and smart solutions to help create the future. We are committed to combining cutting-edge innovation with exceptional product, service, and operation performance with specialize in AI",
        duration = "May 2024 - Present",
        isFullTime = true,
        location = "Pune - onsite"
    ),

    PageAllItemData(
        image = R.drawable.logo_m3_compose,
        heading = "Android App",
        url = "https://play.google.com/store/apps/details?id=com.codexdroid.m3compose",
        title = "M3 Compose",
        desc = "He tends to forget code after periods of inactivity. He likes to understand code logic by seeing the output first and prefers accessing it from anywhere to minimize time spent reading and visualizing code.",
        duration = "March 2024 - Present",
        isFullTime = false,
        location = "Sinnar-onSite"
    ),

    PageAllItemData(
        image = R.drawable.logo_svit,
        heading = "Bachelor Degree",
        url = "https://svitnashik.in/",
        title = "SVIT Nashik",
        desc = "The establishment of the SVIT in 1998-99, symbolized achievement of academic excellence, quality education from pre-primary to collegiate level by PRES Loni, by Late Padmashri Dr. Vitthalrao Vikhe Patil in 1964.",
        duration = "March 2014 - June 2019",
        isFullTime = true,
        location = "Chincholi, Nashik - onsite"
    )
)

//---------------------------------------------------------------------------------------------------------------

data class QuestionsTemplates(val id: Int, val question: String, val answer: String, var isOpen: Boolean = false)

val pageAllQuestionsList = listOf(
    QuestionsTemplates(
        id = 0,
        question = "can you tell me something about yourself?",
        answer = "Myself Akshay Pawar having 3+ years of experience to worked on Native Android with Kotlin, I have worked on 15+ apps among them few are existing and most of then are from scratch and hosted 10+ apps on Play store including self crafted app",
    ),

    QuestionsTemplates(
        id = 1,
        question = "How many project you have done?",
        answer = "I have worked on around 20 projects till now, few of them are form existing to make it stable and most of them are from scratch including finance, security, social media, food and drink, health, educational etc domain."
    ),

    QuestionsTemplates(
        id = 2,
        question = "What is your tech-stack?",
        answer = "I usually preferred to work mostly on kotlin, apart from this I also worked on XML, MYSQL, Firebase, HTML, CSS, JS, Java"
    ),

    QuestionsTemplates(
        id = 3,
        question = "Why Kotlin?",
        answer = "When I started my career, In 2017 Google has announced Kotlin as supportive language for android, I seen kotlin as future because Kotlin has multiple flavor to worked on like Android, KMM(KMP), Server-Side (Ktor), Data Science, and Java Interoperable, That's Why Kotlin 😍"
    )
)