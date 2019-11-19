package com.nirajan.accountmanagement.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.airbnb.mvrx.fragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.nirajan.accountmanagement.R
import com.nirajan.accountmanagement.base.BaseFragment
import com.nirajan.accountmanagement.base.simpleController
import com.nirajan.accountmanagement.login.views.loginView

class LoginFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_login

    private val viewModel by fragmentViewModel(LoginViewModel::class)

    override fun epoxyController() = simpleController {
        loginView {
            id("login-view")
            emailTextChanged(object: TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    viewModel.setEmail(s.toString())
                }
            })

            passwordTextChanged(object: TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    viewModel.setPassword(s.toString())
                }
            })

            buttonClickListener { _ ->
                viewModel.login()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.recycler_view)
        toolbar = view.findViewById(R.id.toolbar)
        coordinatorLayout = view.findViewById(R.id.coordinator_layout)
        recyclerView.setController(epoxyController)

        viewModel.asyncSubscribe(LoginState::loginRequest, onFail = { error ->
            Snackbar.make(coordinatorLayout, "Login request failed.", Snackbar.LENGTH_LONG)
                .show()
            Log.w(TAG, "Login request failed", error)
        })
    }

    companion object {
        private const val TAG = "LoginFragment"
    }
}
