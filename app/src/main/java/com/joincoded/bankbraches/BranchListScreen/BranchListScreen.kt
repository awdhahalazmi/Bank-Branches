package com.joincoded.bankbraches.BranchListScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joincoded.bankbraches.R
import com.joincoded.bankbraches.branchDetails.BranchCard
import com.joincoded.bankbraches.branchDetails.BranchDetails

@Composable
fun BranchDetailsScreen(branch: BranchDetails) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
// Display branch image
        Image(
            painter = painterResource(id = R.drawable.kfh_branch), // Use the actual image resource
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(MaterialTheme.shapes.large),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

// Display branch details
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = "${branch.address} Branch", fontSize = 35.sp, fontWeight = FontWeight.Bold)
            Text(text = "${branch.type}", fontSize = 25.sp)
            Text(text = "Open: ${branch.hours}", fontSize = 25.sp)
            Row(modifier = Modifier.padding(6.dp)) {
                Icon(imageVector = Icons.Default.Phone, contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Phone: ${branch.phone}", fontSize = 25.sp)

            }
            Row() {

                Icon(imageVector = Icons.Default.Place, contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))

                Text(text = "Location: ${branch.location}", fontSize = 25.sp)
                //Text(text =)}


            }



        }
    }
}
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BranchListScreen(
        branchList: List<BranchDetails>,
        onBranchClick: (Int) -> Unit,
        modifier: Modifier = Modifier
    ) {
        Scaffold(modifier = modifier,
            topBar = {
                TopAppBar(title = {
                    Image(
                        painter = painterResource(R.drawable.kfh),
                        contentDescription = null,
                        modifier = Modifier
                            .height(70.dp)
                            .fillMaxWidth(),
                    )
                })
            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
            ) {
                items(branchList) { branch ->
                    BranchCard(branch = branch,
                        modifier = Modifier
                            .clickable {
                                onBranchClick(branch.id)

                            }
                    )
                }
            }
        }
    }
