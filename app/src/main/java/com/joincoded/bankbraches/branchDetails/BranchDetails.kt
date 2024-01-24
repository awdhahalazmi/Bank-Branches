package com.joincoded.bankbraches.branchDetails

data class BranchDetails(val id:Int,
                         val name: String,
                         val type:Type,
                         var address: String,
                         var phone: String,
                         var location: String,
                         var imageUrl:String){

}
