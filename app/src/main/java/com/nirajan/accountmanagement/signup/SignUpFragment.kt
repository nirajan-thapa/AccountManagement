package com.nirajan.accountmanagement.signup

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
import com.nirajan.accountmanagement.signup.views.signUpView

class SignUpFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_sign_up

    private val viewModel by fragmentViewModel(SignUpViewModel::class)

    override fun epoxyController() = simpleController {
        signUpView {
            id("sign-up-view")
            fullNameTextChanged(object: TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    viewModel.setFullName(s.toString())
                }
            })

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
                viewModel.signUp()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.recycler_view)
        toolbar = view.findViewById(R.id.toolbar)
        coordinatorLayout = view.findViewById(R.id.coordinator_layout)
        recyclerView.setController(epoxyController)

        viewModel.asyncSubscribe(SignUpState::signUpRequest, onFail = { error ->
            Snackbar.make(coordinatorLayout, "Sign Up request failed.", Snackbar.LENGTH_LONG)
                .show()
            Log.w(TAG, "Sign Up request failed", error)
        })
    }

    companion object {
        private const val TAG = "SignUpFragment"
    }
}
