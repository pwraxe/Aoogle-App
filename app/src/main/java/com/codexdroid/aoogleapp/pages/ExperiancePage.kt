package pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.R
import com.codexdroid.aoogleapp.common_ui.horizontalLine
import com.codexdroid.aoogleapp.common_ui.SideInfo
import com.codexdroid.aoogleapp.common_ui.experienceItems
import com.codexdroid.aoogleapp.common_ui.locationItems
import com.codexdroid.aoogleapp.common_ui.questionsItem
import com.codexdroid.aoogleapp.common_ui.verticalLine
import com.codexdroid.aoogleapp.data.experienceList
import com.codexdroid.aoogleapp.data.experienceMapList
import com.codexdroid.aoogleapp.data.experienceQuestionsList
import com.codexdroid.aoogleapp.data.pageAllQuestionsList
import com.codexdroid.aoogleapp.ui.theme.fontProductSansNormal


@Preview
@Composable
fun ExperiancePreiview(modifier: Modifier = Modifier) {
    Experience()
}
@Composable
fun Experience(modifier: Modifier = Modifier) {

    val questionsList = remember { pageAllQuestionsList.toMutableStateList() }
    var currentId by remember { mutableIntStateOf(-1) }

    Column(modifier = modifier
        .fillMaxSize()
        .background(color = Color(0XFF202124))) {

        //============================LATEST COMPANY, PROJECT, EDUCATION=================================
        LazyColumn(modifier = modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {

            items(experienceList) {
                experienceItems(it,modifier)
            }

            item {
                Text(
                    text = "People also ask",
                    color = Color(0XFFE8E8E8),
                    fontSize = 20.sp,
                    fontFamily = fontProductSansNormal,
                    modifier = modifier.padding(top = 12.dp)
                )

                horizontalLine(modifier.padding(top = 6.dp))
            }

            items(experienceQuestionsList) { questions ->

                questionsItem(
                    question = questions,
                    currentId,
                    onClickOpen = { id ->
                        currentId = if (currentId == id) -1 else id
                    }
                )
            }

            item {
                Text(
                    text = "Office Places",
                    color = Color(0XFFE8E8E8),
                    fontSize = 20.sp,
                    fontFamily = fontProductSansNormal,
                    modifier = modifier.padding(top = 26.dp)
                )
            }

            item {
                Image(painter = painterResource(R.drawable.map_experience),
                    contentDescription = "",
                    modifier = modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(top = 8.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop,
                )
            }

            items(experienceMapList) {
                locationItems(menuItem = it, modifier = modifier)
            }

            item {
                Spacer(modifier = modifier.padding(vertical = 20.dp))
            }

        }
    }
}