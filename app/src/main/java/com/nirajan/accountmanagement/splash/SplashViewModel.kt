package com.nirajan.accountmanagement.splash

import android.content.SharedPreferences
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.nirajan.accountmanagement.USER_LOGGED_IN
import com.nirajan.accountmanagement.base.BaseViewModel
import org.koin.android.ext.android.inject

data class SplashState(
    val isLoggedIn: Boolean? = null
) : MvRxState

class SplashViewModel(
    initialState: SplashState,
    private val sharedPreferences: SharedPreferences
    ) : BaseViewModel<SplashState>(initialState) {

    fun checkLogInState() = withState {
        // Mocking delay

        val isLoggedIn = sharedPreferences.getBoolean(USER_LOGGED_IN, false)
        setState {
            copy(
                isLoggedIn = isLoggedIn
            )
        }
    }

    companion object : MvRxViewModelFactory<SplashViewModel, SplashState> {

        override fun create(viewModelContext: ViewModelContext, state: SplashState): SplashViewModel {
            val sharedPreferences: SharedPreferences by viewModelContext.activity.inject()
            return SplashViewModel(state, sharedPreferences)
        }
    }
}
