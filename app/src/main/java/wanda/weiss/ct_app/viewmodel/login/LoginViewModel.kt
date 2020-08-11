package wanda.weiss.ct_app.viewmodel.login

import android.annotation.SuppressLint
import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import dagger.android.DaggerApplication
import io.reactivex.subjects.PublishSubject
import org.richit.easiestsqllib.EasiestDB
import wanda.weiss.ct_app.model.observable.login.LoginObservable
import wanda.weiss.ct_app.model.util.find
import wanda.weiss.ct_app.viewmodel.BaseViewModel

@SuppressLint("CheckResult")
class LoginViewModel(application: DaggerApplication) :
    BaseViewModel(application) {

    private val autoCompletePublishSubjectEmail = PublishSubject.create<String>()
    private val autoCompletePublishSubjectPassword = PublishSubject.create<String>()
    private lateinit var obs: LoginObservable
    private lateinit var easiestDB: EasiestDB

    var success = MutableLiveData<Boolean>()
    var pick = MutableLiveData<Boolean>()

    init {
        configureInterceptor(autoCompletePublishSubjectEmail, 0)
            .subscribe { result -> filteredEmail(result) }
        configureInterceptor(autoCompletePublishSubjectPassword, 0)
            .subscribe { result -> filteredPassword(result) }
    }

    fun initDepdendencies(loginObservable: LoginObservable, easiestDB: EasiestDB) {
        this.obs = loginObservable
        this.easiestDB = easiestDB
    }

    fun onEmailChange(text: CharSequence) {
        autoCompletePublishSubjectEmail.onNext(text.toString())
    }

    private fun filteredEmail(result: String) {
        this.obs.apply {
            when {
                Patterns.EMAIL_ADDRESS.matcher(result).matches() -> {
                    emailValid = true
                    email.set(result)
                }
                else -> {
                    emailValid = false
                    email.set("")
                }
            }
        }
    }

    fun onPasswordChange(text: CharSequence) {
        autoCompletePublishSubjectPassword.onNext(text.toString())
    }

    private fun filteredPassword(result: String) {
        this.obs.apply {
            when {
                result.length >= 6 -> {
                    passwordValid = true
                    password.set(result)
                }
                else -> {
                    passwordValid = false
                    password.set("")
                }
            }
        }
    }

    fun onLogin() {
        success.value = find(easiestDB, obs.email.get()!!, obs.password.get()!!)
    }

    fun onCountryPick(){
        pick.value = true
    }

}