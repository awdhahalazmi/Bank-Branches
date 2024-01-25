package com.joincoded.bankbraches.branchDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joincoded.bankbraches.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.nio.file.WatchEvent


@Composable
fun BranchCard(
    branch: BranchDetails,
    modifier: Modifier = Modifier
) {
    var isFavorite by remember { mutableStateOf(false) }


    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(310.dp)
            .padding(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier.fillMaxWidth().padding(2.dp)
            ) {
                val imageModifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .padding(10.dp)
                    .clip(shape = MaterialTheme.shapes.large)

                branch.imageUrl.let {
                    Image(
                        painter = painterResource(id = it!!),
                        contentDescription = null,
                        modifier = imageModifier,
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(1.dp))

                Row() {
                    Icon(imageVector = Icons.Default.Place, contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${branch.address} Branch",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(text = "${branch.type}", fontSize = 18.sp)
                Text(text = "Open ${branch.hours}", fontSize = 18.sp)
                Row() {
                    Icon(imageVector = Icons.Default.Phone, contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Phone: ${branch.phone}", fontSize = 18.sp)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End

                ) {

                    Image(painter = painterResource(id = if (isFavorite) R.drawable.favorite else R.drawable.fav),
                        contentDescription = null,
                        modifier = Modifier
                            .height(130.dp)
                            .clickable {

                                isFavorite = true
                                branch.favorite=isFavorite
                            })

                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BranchDetailstPreview() {
    BranchCard(
        branch = BranchDetails(
            1233,
            "KFH",
            Type.KFHAUTO,
            "Shuwaikh",
            "987654322",
            "Shuwaikh",
            "7:30AM - 3:00PM ",
            R.drawable.kfh_branch,
            false
        )
    )
}










