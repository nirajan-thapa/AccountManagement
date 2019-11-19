package com.nirajan.accountmanagement.login.views

import android.content.Context
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.nirajan.accountmanagement.R
import kotlinx.android.synthetic.main.login_view.view.email
import kotlinx.android.synthetic.main.login_view.view.login_btn
import kotlinx.android.synthetic.main.login_view.view.password

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class LoginView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.login_view, this)
    }

    @CallbackProp
    fun setButtonClickListener(clickListener: OnClickListener?) {
        login_btn.setOnClickListener(clickListener)
    }

    @CallbackProp
    fun setEmailTextChanged(onTextWatcher: TextWatcher?) {
        email.addTextChangedListener(onTextWatcher)
    }

    @CallbackProp
    fun setPasswordTextChanged(onTextWatcher: TextWatcher?) {
        password.addTextChangedListener(onTextWatcher)
    }
}
