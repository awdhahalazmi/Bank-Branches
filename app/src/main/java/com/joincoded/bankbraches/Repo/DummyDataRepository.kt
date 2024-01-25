package com.joincoded.bankbraches.Repo

import com.joincoded.bankbraches.branchDetails.BranchDetails
import com.joincoded.bankbraches.branchDetails.Type

object DummyDataRepository {

    fun getDummyBranchList(): List<BranchDetails> {

        return listOf(
            BranchDetails(id = 1, name = "Awdhah", type = Type.XTM, address = "Address 1", phone = "123456", location = "Location 1", imageUrl = "url1"),
            BranchDetails(id = 2, name = "Mafaz", type = Type.ATM, address = "Address 2", phone = "789012", location = "Location 2", imageUrl = "url2"),
            BranchDetails(id = 1, name = "Amal", type = Type.XTM, address = "Address 1", phone = "123456", location = "Location 1", imageUrl = "url1"),
            BranchDetails(id = 1, name = " Haya", type = Type.XTM, address = "Address 1", phone = "123456", location = "Location 1", imageUrl = "url1"),
            BranchDetails(id = 1, name = "Branch 1", type = Type.XTM, address = "Address 1", phone = "123456", location = "Location 1", imageUrl = "url1"),

            )
    }
}
