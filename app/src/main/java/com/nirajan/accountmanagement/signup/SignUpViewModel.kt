package com.nirajan.accountmanagement.signup

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.ViewModelContext
import com.nirajan.accountmanagement.base.BaseViewModel

data class SignUpState(
    val fullName: String? = null,
    val email: String? = null,
    val password: String? = null,
    val signUpRequest: Async<Any> = Uninitialized
) : MvRxState

class SignUpViewModel(
    initialState: SignUpState
) : BaseViewModel<SignUpState>(initialState) {

    fun setFullName(fullName: String) = setState {
        copy(
            fullName = fullName
        )
    }

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

    fun signUp() =
        withState {

        }

    companion object : MvRxViewModelFactory<SignUpViewModel, SignUpState> {

        override fun create(viewModelContext: ViewModelContext, state: SignUpState): SignUpViewModel {
            return SignUpViewModel(state)
        }
    }
}
