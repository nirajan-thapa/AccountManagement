package com.nirajan.accountmanagement.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.nirajan.accountmanagement.R
import com.nirajan.accountmanagement.base.BaseActivity
import com.nirajan.accountmanagement.signup.SignUpActivity

class SplashActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun intent(context: Context) = Intent(context, SignUpActivity::class.java)
    }
}
