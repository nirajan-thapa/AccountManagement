package com.nirajan.accountmanagement.api

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.PATCH
import retrofit2.http.POST

interface MirrorService {

    @FormUrlEncoded
    @POST("api/v1/auth/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Observable<LoginResponse>

    @FormUrlEncoded
    @POST("api/v1/auth/signup")
    fun signUp(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("password2") password2: String
    ): Observable<SignUpResponse>

    @FormUrlEncoded
    @PATCH("api/v1/user/me")
    fun updateProfile(
        @Field("name") name: String,
        @Field("location") location: String,
        @Field("birthday") birthday: String
    ): Single<Any>
}
