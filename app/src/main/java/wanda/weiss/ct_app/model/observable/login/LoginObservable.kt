package wanda.weiss.ct_app.model.observable.login

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import wanda.weiss.ct_app.BR
import javax.inject.Inject

class LoginObservable @Inject constructor() : BaseObservable() {

    var email = ObservableField<String>()
    var password = ObservableField<String>()

    @get:Bindable
    var loggingIn: Boolean = false
        set(loggingIn) {
            field = loggingIn
            notifyPropertyChanged(BR.loggingIn)
        }

    @get:Bindable
    var emailValid: Boolean = false
        set(emailValid) {
            field = emailValid
            notifyPropertyChanged(BR.emailValid)
        }

    @get:Bindable
    var passwordValid: Boolean = false
        set(passwordValid) {
            field = passwordValid
            notifyPropertyChanged(BR.passwordValid)
        }

}