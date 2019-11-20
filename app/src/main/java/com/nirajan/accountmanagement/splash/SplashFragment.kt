package com.nirajan.accountmanagement.splash

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.airbnb.mvrx.fragmentViewModel
import com.nirajan.accountmanagement.R
import com.nirajan.accountmanagement.base.BaseFragment
import com.nirajan.accountmanagement.base.simpleController
import com.nirajan.accountmanagement.login.LoginActivity

class SplashFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_splash

    private val viewModel by fragmentViewModel(SplashViewModel::class)

    override fun epoxyController() = simpleController {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbar = view.findViewById(R.id.toolbar)
        coordinatorLayout = view.findViewById(R.id.coordinator_layout)
        toolbar.title = resources.getString(R.string.app_name)

        viewModel.selectSubscribe(
            SplashState::isLoggedIn,
            subscriber = {
                it?.apply {
                    // go to profile
                    if (this)
                        Log.d(TAG, "Go to profile screen")
                    else
                        goToLogin()
                }
            }
        )
        // Mocking delay
        Handler().postDelayed(
            { viewModel.checkLogInState() },
            500
        )
    }

    private fun goToLogin() {
        Log.d(TAG, "goToLogin")
        activity?.let {
            startActivity(LoginActivity.intent(it))
            it.finish()
        }
    }

    companion object {
        private const val TAG = "SplashFragment"
    }
}
