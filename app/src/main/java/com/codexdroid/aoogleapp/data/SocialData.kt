package data

import com.codexdroid.aoogleapp.R


data  class SocialData(val id: Int, val icon: Int,val name:String, val url: String,)

val socials = listOf(
    SocialData(id = 1, R.drawable.ic_gmail,"Gmail", "https://mail.google.com/mail/?view=cm&fs=1&to=pawarakshay13@gmail.com"),
    SocialData(id = 2, R.drawable.ic_google,"Google", url = "https://g.dev/akshay96"),
    SocialData(id = 3, R.drawable.ic_linkedin,"LinkedIn", url = "https://www.linkedin.com/in/akshay-pawar-b7a0a8135"),
    SocialData(id = 4, R.drawable.ic_playstore,"Play Store", url = "https://play.google.com/store/apps/developer?id=Codexdroid"),
    SocialData(id = 5, R.drawable.ic_leetcode,"Leetcode", url = "https://leetcode.com/pawarakshay13"),
    SocialData(id = 6, R.drawable.ic_github,"GitHub", url = "https://github.com/pwraxe"),
    SocialData(id = 7, R.drawable.ic_internet,"Jetpack Compose", url = "https://pwraxe.github.io/compose/index.html"),
)