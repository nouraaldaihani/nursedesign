package com.noura.nursecom.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noura.nursecom.R

data class UserProfile(
    val username: String,
    val age: Int,
    val civilId: String,
    val medicalRecord: String,
    val profilePicture: Int
)

@Composable
fun ProfilePage(userProfile: UserProfile) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfilePicture(profilePicture = userProfile.profilePicture)
        Spacer(modifier = Modifier.height(16.dp))
        UserInfoItem(label = "Username", value = userProfile.username)
        UserInfoItem(label = "Age", value = userProfile.age.toString())
        UserInfoItem(label = "Civil ID", value = userProfile.civilId)
        UserInfoItem(label = "Medical Record", value = userProfile.medicalRecord)
    }
}

@Composable
fun ProfilePicture(profilePicture: Int) {
    Image(
        painter = painterResource(id = profilePicture),
        contentDescription = "Profile Picture",
        modifier = Modifier
            .padding(15.dp)
            .size(120.dp)
            .clip(CircleShape)
            .border(4.dp, Color.Gray, CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun UserInfoItem(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
            .border(2.dp, Color.LightGray, RoundedCornerShape(8.dp))
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$label: ",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black ,
            modifier = Modifier
                .padding(2.dp)
                .width(100.dp)
        )
        Text(
            text = value,
            fontSize = 16.sp,
            color = Color.Blue

        )
    }
}


@Composable
fun UserProfileScreen(function: () -> Unit) {
    val userProfile = UserProfile(
        username = "Noura Aldaihani",
        age = 24,
        civilId = "123456789",
        medicalRecord = "Iron IV Drip",
        profilePicture = R.drawable.profile_picture
    )
    ProfilePage(userProfile = userProfile)
}

@Preview
@Composable
fun PreviewUserProfileScreen() {
    UserProfileScreen {
    }
}