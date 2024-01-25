package com.joincoded.bankbraches.Nav

import android.service.autofill.OnClickAction
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankbraches.BranchListScreen.BranchDetailsScreen
import com.joincoded.bankbraches.BranchListScreen.BranchListScreen
import com.joincoded.bankbraches.branchDetails.BranchDetails

@Composable
fun HomeNav(branchsList: List<BranchDetails>) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "branchsList")
    {
        composable("branchsList")
        {
            BranchListScreen(branchList = branchsList,
                onBranchClick = {
                    navController.navigate("branchesDetails/${it}")
                })
        }

        composable("branchesDetails/{id}")
        {
            var branchId = it.arguments?.getString("id")
            //branchsList.find {
            val filterBranchList = branchsList.filter { branch ->
                branch.id == branchId?.toInt()
            }
            BranchDetailsScreen(filterBranchList[0])

        }
    }
}
