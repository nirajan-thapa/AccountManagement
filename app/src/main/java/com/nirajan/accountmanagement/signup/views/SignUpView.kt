package com.nirajan.accountmanagement.signup.views

import android.content.Context
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.nirajan.accountmanagement.R
import kotlinx.android.synthetic.main.login_view.view.email
import kotlinx.android.synthetic.main.login_view.view.password
import kotlinx.android.synthetic.main.sign_up_view.view.full_name
import kotlinx.android.synthetic.main.sign_up_view.view.sign_up_btn

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class SignUpView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.sign_up_view, this)
    }

    @CallbackProp
    fun setButtonClickListener(clickListener: OnClickListener?) {
        sign_up_btn.setOnClickListener(clickListener)
    }

    @CallbackProp
    fun setFullNameTextChanged(onTextWatcher: TextWatcher?) {
        full_name.addTextChangedListener(onTextWatcher)
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
