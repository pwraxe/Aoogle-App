package com.codexdroid.aoogleapp.data

import com.codexdroid.aoogleapp.R
import com.codexdroid.aoogleapp.common_ui.MapItemData
import com.codexdroid.aoogleapp.utils.getActualExperience
import com.codexdroid.aoogleapp.utils.getFreelanceExperience
import com.codexdroid.aoogleapp.utils.getTotalExperience
import data.Details

data class ExperienceData (
    val id: Int,
    val image: Int,
    val titlePosition: String,
    val websiteLink: String,
    val companyName: String,
    val duration: String,
    val workMode: String,
    val workLocation: String,
    val workType: String,
    val bulletPoints: List<String>
)

val experienceList = listOf (

    ExperienceData(
        id = 1,
        image = R.drawable.logo_mobile_llc,
        titlePosition = Details.ROLE.SOFT_DEV,
        websiteLink = Details.LINKS.URL_COMP_4,
        companyName = Details.COMPANY.PROGRAMMING,
        duration = "May 2024 - Present",
        workMode = "Full-Time",
        workLocation = "Pune",
        workType = "WFO",
        bulletPoints = listOf(
            "Working at Client Side"
        )
    ),

    ExperienceData(
        id = 2,
        image = R.drawable.logo_mobihive_sq,
        titlePosition = Details.ROLE.SR_POS,
        websiteLink = Details.LINKS.URL_COMP_3,
        companyName = Details.COMPANY.MOBIHIVE,
        duration = "Sept 2022 - April 2023",
        workMode = "Full Time",
        workLocation = "Sinnar",
        workType = "WFH",
        bulletPoints = listOf(
            "Design and Develop from scratch to reduce agent time by 30-50%.",
            "Amplified customer contentment by 20% through the empowerment of agents with a stream lined mobile app.",
            "Elevated customer validation rates by 40% and mitigated fake photos and impersonation by 50%  through the implementation of live image capturing." ,
            "Mastered CRM workflows at 80-90% proficiency, aiding rapid onboarding for new team members.",
            "Led 40% customer base growth, lightened agent workloads by 50% with the self-service Customer App.",
            "Independently resolved 2-5% of agent queries, achieving a 45-60% satisfaction rate and driving a substantial 40% enhancement in CRM efficiency"
        )
    ),

    ExperienceData(
        id = 3,
        image = R.drawable.logo_inno_short,
        titlePosition = Details.ROLE.SR_POS,
        websiteLink = Details.LINKS.URL_COMP_2,
        companyName = Details.COMPANY.INNOVATIONS,
        duration = "Oct 2021 - Sept 2022",
        workMode = "Full Time",
        workLocation = "Nashik",
        workType = "Hybrid",
        bulletPoints = listOf(
            "App (Kitchenbaba): Enhanced app stability and performance by 30% resolving 20% of existing bugs.",
            "App (Project Mamta): Slashed client costs by 40-45% on agent fuel, achieving a 20% boost in location accuracy, resulting in a 40% revenue increase.",
            "App (Sky Recharge): Drove a 40% surge in the client sales via the development and implementation, expanded distributor network by 20%, and processed 10-15 lakh transactions in the last 6-8 months.",
            "App (Parrot4Business): Took initiative of clients achieve their objectives, reducing communication gaps by 60% increasing sales by 20% and fostering customer acquisition and retention through the app.",
            "Productivity: Optimized company operations, reducing costs by 40-60% by streamlining design processes, while building a 40% increase in trust through consistent on-time delivery.",
            "Productivity: Mentored junior developers, boosting their productivity by 30%."
        )
    ),

    ExperienceData(
        id = 3,
        image = R.drawable.logo_pinnale,
        titlePosition = Details.ROLE.SOFT_DEV,
        websiteLink = Details.LINKS.URL_COMP_1,
        companyName = Details.COMPANY.PINNACLE,
        duration = "Oct 2021 - Sept 2022",
        workMode = "Full Time",
        workLocation = "Sinnar",
        workType = "WFH",
        bulletPoints = listOf(
            "App (Glasswing [Old]): Enhanced app performance by 40% through proactive bug and crash resolution.",
            "App: (Glasswing [New]): Created a sleek new application with a contemporary UI from the ground up.",
            "Productivity: Expanded the user base by 10% and revenue by 30% with a user-centric app, enhancing engagement and overall experience.",
            "Productivity: Cross-team collaboration, leading to a 10% boost in productivity.")
    )
)

val experienceQuestionsList = listOf(
    QuestionsTemplates(
        id = 0,
        question = "What is your total Experience?",
        answer = "It has been ${getTotalExperience()} years in IT industry where I am having ${getActualExperience()} year of actual experience ${getFreelanceExperience()} years is freelancing expedience, apart from this I was use to study and create small project in my collage days and in covid-19 period"
    ),


    QuestionsTemplates(
        id = 1,
        question = "Why did you start career with kotlin?",
        answer = "After lots of researched regarding technology to choose,I have found Android domain as a grate start, When I started my career, In 2017 Google has announced Kotlin as supportive language for android, I seen kotlin as future because Kotlin has multiple flavor to worked on like Android, KMM(KMP), Server-Side (Ktor), Data Science, and Java Interoperable, That's Why Kotlin 😍."
    ),

    QuestionsTemplates(
        id = 2,
        question = "Why did you join same company again in May 2023?",
        answer = "In May 2023 When I left MobiHive Organization, I start looking for Job, applied many organization but no reply or response from HR, at same Time InnovationsHub Services has a project and Manager wants me to work on that project. As I also want a job hence I had started as Freelancing"
    ),

    QuestionsTemplates(
        id = 3,
        question = "What is best thing you learn from your career or experience or senior?",
        answer = "Not from Senior Yet, but from my career I learn to take responsibilities, against work, should be commited to work it will indirectly helps us in our growth. independence, problem solving strategy, Learning and Officially implemented SDLC Lifecycle in my career."
    )
)

val experienceMapList = listOf(

    MapItemData(
        title = "Mobile Programming India Pvt. Ltd.",
        address = "8th Floor East-Court, Phoenix Marketcity,, 808, 809, Viman Nagar, Pune, 411014",
        hours = "9:00 AM - 06:00 PM",
        websiteUrl = "https://programming.com/",
        directionUrl = "https://maps.app.goo.gl/4YmW9HkMKdtzuEiz7"
    ),

    MapItemData(
        title = "MobiHive Labs Limited, London",
        address = "61 Clayhall Avenue, Barkingside, London, IG5 0PW",
        hours = "11:00 AM - 08:30 PM",
        websiteUrl = "https://mobihivelabs.com/",
        directionUrl = "https://maps.app.goo.gl/pPbF5BioXwV4qts66"
    ),

    MapItemData(
        title = "InnovationsHub Services Pvt Ltd",
        address = "4/5 Bele Sankul, Ghankar Ln, Raviwar Karanja, Nashik, Maharashtra, India 422 001",
        hours = "10:00 AM - 07:00 PM",
        websiteUrl = "https://innovationshub.in/",
        directionUrl = "https://goo.gl/maps/RLssUPVKZUpabJFV7"
    ),

    MapItemData(
        title = "Pinnacle IT Solutions",
        address = "703, A wing, Mahalaxmi nagar, Urit Nagar, Warje, Pune, Maharashtra 411058",
        hours = "10:30 AM - 8:00 PM",
        websiteUrl = "https://www.pinnacleit.in/",
        directionUrl = "https://maps.app.goo.gl/VjjvPyfhWbdbhXtu5"
    )
)