package com.nirajan.accountmanagement.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.Date

@Parcelize
data class User(
    val userUuid: String? = null,
    val userToken: String? = null,
    val apiToken: String? = null,
    val name: String? = null,
    val location: String? = null,
    val birthday: Date? = null
) : Parcelable
