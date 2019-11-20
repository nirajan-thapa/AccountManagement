package com.nirajan.accountmanagement.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.nirajan.accountmanagement.R
import com.nirajan.accountmanagement.base.BaseActivity

class SignUpActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_sign_up

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun intent(context: Context) = Intent(context, SignUpActivity::class.java)
    }
}
