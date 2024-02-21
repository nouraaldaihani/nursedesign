package com.noura.nursecom.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.noura.nursecom.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Button as Button1


data class Nurse(
    val name: String,
    val price: String,
    val speciality: String,
    val rating: Int,
    val image: Int,
)

class NurseList {
    val nurses = listOf(
        Nurse("Nurse 1", "20 KWD/Hour", "Cardio", 5, R.drawable.nurse1),
        Nurse("Nurse 2", "20 KWD/Hour", "ER", 5, R.drawable.nurse2),
        Nurse("Nurse 3", "20 KWD/Hour", "ICU", 3, R.drawable.nurse1),
        Nurse("Nurse 4", "20 KWD/Hour", "Surgery", 4, R.drawable.nurse2),
        Nurse("Nurse 5", "20 KWD/Hour", "Oncology", 5, R.drawable.nurse1)
    )
}


@Composable
fun NursesScreen() {
    val nurseList = NurseList()
    var selectedPeriod by remember {
        mutableStateOf("AM")

    }

    Column(modifier = Modifier.fillMaxWidth()) {

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp)
        )
        {
            items(listOf("AM", "PM", "Full Time"))
            { period ->
                Button1(
                    onClick = { /*Handle button click*/ },
//                    { selectedPeriod = period }
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .height(35.dp)
                        .width(121.dp)

                ) {
                    Text(period)
                }
            }
        }

        LazyRow(modifier = Modifier.padding(horizontal = 16.dp, vertical = 1.dp))
        {
            items(listOf("Female", "Male"))
            { speciality ->
                Button1(
                    onClick = { /*Handle button click*/ },
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .height(35.dp)
                        .width(185.dp)
                ) {
                    Text(speciality)


                }
            }
        }

        LazyRow(modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp))
        {
            items(listOf("Cardio", "ER", "ICU", "Surgery", "Oncology"))
            { speciality ->
                Button1(
                    onClick = { /*Handle button click*/ },
                    Modifier.padding(end = 6.dp)
                ) {
                    Text(speciality)

                }
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(nurseList.nurses) { nurse ->
                NurseCard(nurse = nurse)
            }
        }
    }
}

@Composable
fun NurseCard(nurse: Nurse) {


    Row(
        modifier = Modifier
            .padding(16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .padding(16.dp),


//        verticalAlignment = Alignment.CenterVertically,

    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        )

        {
            Text(
                text = nurse.name,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )

            Text(text = nurse.speciality)
            Text(text = nurse.price)
            Rating(rating = 2)
        }
        Image(
            modifier = Modifier.size(90.dp),
            painter = painterResource(nurse.image),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop
        )
    }

    Button1(

        onClick = { /*Handle Booking action*/ },
        modifier = Modifier
            .padding(8.dp)
            .height(35.dp)
    )

    {
        Text("Book Now")
    }

}


@Composable
fun Rating(rating: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        repeat(rating) {
            Image(
                painter = painterResource(id = R.drawable.star_filled),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }
        repeat(5 - rating) {
            Image(
                painter = painterResource(id = R.drawable.star_empty),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
            )
        }
    }
}

@Preview
@Composable
fun PreviewNursesScreen() {
    NursesScreen()
}
