package com.joincoded.bankbraches

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.joincoded.bankbraches.Nav.HomeNav
import com.joincoded.bankbraches.Repo.BankBranchesRepo
import com.joincoded.bankbraches.branchDetails.BranchCard
import com.joincoded.bankbraches.branchDetails.BranchDetails
import com.joincoded.bankbraches.branchDetails.Type
import com.joincoded.bankbraches.ui.theme.BankBrachesTheme


class MainActivity : ComponentActivity() {
    var branches = BankBranchesRepo.dummyBranchesList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankBrachesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeNav(branchsList = branches)

                    }
                }
            }
        }
    }



//
//@Composable
//fun BranchList(
//    branchList: List<BranchDetails>,
//    // Unit no return type
//    modifier: Modifier = Modifier1
//) {
//    LazyColumn(modifier = modifier) {
//        items(branchList) { branchs ->
//            BranchCard(
//                type = branchs.type,
//                address = branchs.address,
//                phone = branchs.phone,
//                hours = branchs.hours,
//                imageUrl = branchs.imageUrl,
//                Modifier = modifier
//            )
//
//        }
//        @Composable
//        fun BranchScreen(
//            brancheList: List<BranchDetails>,
//            modifier: Modifier = Modifier1
//        ) {
//
//            LazyColumn(modifier = modifier) {
//                items(brancheList) { branches ->
//                    BranchDetails(
//                        id = branches.id,
//                        name = branches.name,
//                        type = branches.type,
//                        address = branches.address,
//                        phone = branches.phone,
//                        location = branches.location,
//                        hours = branches.hours,
//                        imageUrl = branches.imageUrl
//
//
//                    )
//                }
//            }
//        }
//

