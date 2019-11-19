package com.nirajan.accountmanagement.base

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.nirajan.accountmanagement.BuildConfig

abstract class BaseViewModel<S : MvRxState>(initialState: S) :
    BaseMvRxViewModel<S>(initialState, debugMode = BuildConfig.DEBUG)
