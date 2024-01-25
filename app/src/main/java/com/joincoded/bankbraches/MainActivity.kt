package com.joincoded.bankbraches

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joincoded.bankbraches.Repo.DummyDataRepository
import com.joincoded.bankbraches.branchDetails.BranchDetails
import com.joincoded.bankbraches.branchDetails.BranchDetailsPage
import com.joincoded.bankbraches.branchDetails.Type
import com.joincoded.bankbraches.branchcard.BranchCard
import com.joincoded.bankbraches.branchcard.BranchList
import com.joincoded.bankbraches.ui.theme.BankBranchColors
import com.joincoded.bankbraches.ui.theme.BankBranchTheme

class MainActivity : ComponentActivity() {
    private var currentBranch: BranchDetails? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankBranchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var branches by remember { mutableStateOf(DummyDataRepository.getDummyBranchList()) }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(BankBranchColors.primary)
                    ) {
                        // Upper part with top bar and KPH image
                        TopBarWithImage()
                        Spacer(modifier = Modifier.height(8.dp))

                        // Lower part with card lists
                        BranchList(
                            branchListState = remember { mutableStateOf(branches) },
                            onBranchClick = { branchId ->
                                currentBranch = branches.find { it.id == branchId }
                            },
                            onSortClick = {
                                branches = branches.sortedBy { it.name }
                            }
                        )

                        if (currentBranch != null) {
                            BranchDetailsPage(branch = currentBranch!!, onBackClick = {
                                currentBranch = null
                            })
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.kfh),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()

                .height(80.dp),
            contentScale = ContentScale.None
        )


    }
}

