package com.joincoded.bankbraches.Repo

import com.joincoded.bankbraches.R
import com.joincoded.bankbraches.branchDetails.BranchDetails
import com.joincoded.bankbraches.branchDetails.Type


class BankBranchesRepo {

    companion object {
        var dummyBranchesList = listOf(
            BranchDetails(
                12344, "KFH", Type.KFHAUTO,
                "Shuwaikh", "1803 333",
                "Jahra Road", "7:30AM - 3:00PM",
                R.drawable.kfh_auto,
                false

            ),
            BranchDetails(
                12354, "KFH", Type.GO,
                "AlSalam", "1803 333",
                "Block 4 Street 24", "24 hours",
                R.drawable.kfh_go,
                false

            ),
            BranchDetails(
                34567, "KFH", Type.ATM,
                "Kuwait City", "1803 333",
                "Jahra Road", "8:00AM - 3:00PM",
                R.drawable.kfh_branch,
                false

            ),
            BranchDetails(
                8765, "KFH", Type.ATM,
                "Quortba", "1803 333",
                "Jahra Road", "8:00AM - 3:00PM",
                R.drawable.kfh_branch,
                false

            ))
    }
}
