package com.ruhlanusubov.ecommerceretrofit.userdata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInfo(
    val email:String
):Parcelable
