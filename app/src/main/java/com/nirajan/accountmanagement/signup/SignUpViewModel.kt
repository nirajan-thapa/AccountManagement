package com.nirajan.accountmanagement.signup

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.ViewModelContext
import com.nirajan.accountmanagement.api.MirrorService
import com.nirajan.accountmanagement.base.BaseViewModel
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject

data class SignUpState(
    val fullName: String? = null,
    val email: String? = null,
    val password: String? = null,
    val signUpRequest: Async<Any> = Uninitialized
) : MvRxState

class SignUpViewModel(
    initialState: SignUpState,
    private val mirrorService: MirrorService
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

    fun signUp() = withState { state ->
        if (state.signUpRequest is Loading) return@withState

        if (state.email == null || state.fullName == null || state.password == null)
            return@withState

        mirrorService
            .signUp(
                name = state.fullName,
                email = state.email,
                password = state.password,
                password2 = state.password
            )
            .subscribeOn(Schedulers.io())
            .execute {
                copy (
                    signUpRequest = it
                )
            }
    }

    companion object : MvRxViewModelFactory<SignUpViewModel, SignUpState> {

        override fun create(viewModelContext: ViewModelContext, state: SignUpState): SignUpViewModel {
            val mirrorService: MirrorService by viewModelContext.activity.inject()
            return SignUpViewModel(state, mirrorService)
        }
    }
}
