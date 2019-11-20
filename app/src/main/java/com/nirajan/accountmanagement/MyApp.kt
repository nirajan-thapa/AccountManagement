package com.nirajan.accountmanagement

import android.app.Application
import android.content.Context
import com.google.gson.GsonBuilder
import com.nirajan.accountmanagement.MyApp.Companion.LOGIN_PREF
import com.nirajan.accountmanagement.api.MirrorService
import com.squareup.moshi.Moshi
import com.squareup.moshi.Moshi.Builder
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(mirrorService)
        }
    }

    companion object {
        const val LOGIN_PREF = "login_pref"
    }
}

private val mirrorService = module {
    factory {
        Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    factory {
        Retrofit.Builder()
            .baseUrl("https://dev.refinemirror.com/")
            .addConverterFactory(MoshiConverterFactory.create(get<Moshi>()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(MirrorService::class.java)
    }

    single {
        androidApplication().getSharedPreferences(LOGIN_PREF, Context.MODE_PRIVATE)
    }

    single {
        GsonBuilder().create()
    }

}
