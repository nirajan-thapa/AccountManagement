package com.nirajan.accountmanagement.api

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.PATCH
import retrofit2.http.POST

interface MirrorService {

    @FormUrlEncoded
    @POST("/auth/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Single<Response<Any>>

    @FormUrlEncoded
    @POST("/auth/signup")
    fun signUp(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Single<Any>

    @FormUrlEncoded
    @PATCH("/user/me")
    fun updateProfile(
        @Field("name") name: String,
        @Field("location") location: String,
        @Field("birthday") birthday: String
    ): Single<Any>
}
