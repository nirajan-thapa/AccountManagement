package com.nirajan.accountmanagement.api

import com.squareup.moshi.Json

data class SignUpResponse(
    @get:Json(name = "message") @Json(name = "message") val message: String,
    @get:Json(name = "data") @Json(name = "data") val data: SignUpData
)

data class SignUpData(
    @get:Json(name = "user_uuid") @Json(name = "user_uuid") val user_uuid: String,
    @get:Json(name = "user_token") @Json(name = "user_token") val user_token: String,
    @get:Json(name = "api_token") @Json(name = "api_token") val api_token: String
)
