package com.joincoded.bankbraches.branchcard

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.joincoded.bankbraches.branchDetails.BranchDetails
import com.joincoded.bankbraches.branchDetails.Type
import com.joincoded.bankbraches.ui.theme.BankBranchColors

// Inside BranchCard.kt
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BranchCard(branch: BranchDetails, onClick: () -> Unit, onLocationClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(150.dp)
            .clickable { onClick.invoke() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BankBranchColors.primaryVariant)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "Branch ID: ${branch.id}",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = "Branch Name: ${branch.name}",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Place, contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    // Clickable Location Text
                    Text(
                        text = branch.location,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.clickable { onLocationClick.invoke() }
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Phone, contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = branch.phone,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}

// Inside BranchList.kt
@Composable
fun BranchList(
    branchListState: MutableState<List<BranchDetails>>,
    onBranchClick: (Int) -> Unit,
    onSortClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BankBranchColors.primary)
            .padding(8.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    onClick = { onSortClick() },
                ) {
                    Text("Sort by Name", color = Color.White)
                }
            }
        }
        items(branchListState.value) { branch ->
            BranchCard(
                branch = branch,
                onClick = { onBranchClick(branch.id) },
                onLocationClick = {
                    // Handle click on location (e.g., launch Google Maps intent)
                    // Implement the logic to launch Google Maps with the branch location
                    // You can use an Intent or a navigation library like Accompanist Navigation
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}