package com.joincoded.bankbraches.branchDetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.joincoded.bankbraches.R

data class BranchDetails(val id:Int,
                         val name: String,
                         val type:Type,
                         var address: String,
                         var phone: String,
                         var location: String,
                         val hours: String,
                         var imageUrl:Int?,
                         var favorite: Boolean) {




    }

