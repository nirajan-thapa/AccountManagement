package com.nirajan.accountmanagement.api

import com.squareup.moshi.Json

data class LoginResponse(
    @get:Json(name = "message") @Json(name = "message") val message: String,
    @get:Json(name = "data") @Json(name = "data") val data: LoginData
)

data class LoginData(
    @get:Json(name = "user_token") @Json(name = "user_token") val user_token: String,
    @get:Json(name = "api_token") @Json(name = "api_token") val api_token: String
)
