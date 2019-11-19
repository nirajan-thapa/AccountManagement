package com.nirajan.accountmanagement.login

import android.util.Log
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.ViewModelContext
import com.nirajan.accountmanagement.base.BaseViewModel

data class LoginState(
    val email: String? = null,
    val password: String? = null,
    val loginRequest: Async<Any> = Uninitialized
) : MvRxState

class LoginViewModel(
    initialState: LoginState
) : BaseViewModel<LoginState>(initialState) {

    fun setEmail(email: String) = setState {
        copy(
            email = email
        )
    }

    fun setPassword(password: String) = setState {
        copy(
            password = password
        )
    }

    fun login() =
        withState {
            Log.d("LoginViewModel", "$it")
        }

    /**
     * If you implement MvRxViewModelFactory in your companion object, MvRx will use that to create
     * your ViewModel. You can use this to achieve constructor dependency injection with MvRx.
     *
     * @see MvRxViewModelFactory
     */
    companion object : MvRxViewModelFactory<LoginViewModel, LoginState> {

        override fun create(viewModelContext: ViewModelContext, state: LoginState): LoginViewModel {
            return LoginViewModel(state)
        }
    }
}
