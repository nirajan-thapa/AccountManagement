package com.nirajan.accountmanagement.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.nirajan.accountmanagement.R
import com.nirajan.accountmanagement.base.BaseActivity

class LoginActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun intent(context: Context) = Intent(context, LoginActivity::class.java)
    }
}
