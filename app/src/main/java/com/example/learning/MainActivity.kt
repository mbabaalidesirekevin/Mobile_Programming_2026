package com.example.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learning.ui.theme.LearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningTheme {
                StudentIdCard()

            }
        }
    }
}
@Composable
fun StudentInfo() {
    val profileImage = painterResource(R.drawable.photo)
    val logoImage = painterResource(R.drawable.ndu_logo)
    Column (
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        Box {
            Image(
                painter = profileImage,
                contentDescription = "Student Photo",
                contentScale = ContentScale.Crop,
                //this code is to put round coners on the profile image
                modifier = Modifier
                    .clip(RoundedCornerShape(percent = 10))
            )
            Image(
                painter = logoImage,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.BottomEnd)
                    .padding(4.dp)
            )
        }
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Text(
            text = stringResource(R.string.student_name),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary

        )
        Text(
            text = stringResource(R.string.course),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary


        )
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 24.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant

            )
        Row{
            Text(
                text = "REG NO:",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary

            )
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Text(
                text = stringResource(R.string.reg_no),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}


@Composable
fun StudentIdCard() {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.elevatedCardColors(
            MaterialTheme.colorScheme.surfaceVariant.copy(alpha =0.3f)
        )
    ) {
    StudentInfo()
    }

}
@Preview(showBackground = true)
@Composable
fun LearningPreview(){
    LearningTheme {
        StudentIdCard()
    }
}
