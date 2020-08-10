package wanda.weiss.ct_app.viewmodel.login

import android.annotation.SuppressLint
import android.util.Patterns
import dagger.android.DaggerApplication
import io.reactivex.subjects.PublishSubject
import org.richit.easiestsqllib.EasiestDB
import timber.log.Timber
import wanda.weiss.ct_app.model.observable.login.LoginObservable
import wanda.weiss.ct_app.model.util.find
import wanda.weiss.ct_app.viewmodel.BaseViewModel

@SuppressLint("CheckResult")
class LoginViewModel(application: DaggerApplication) :
    BaseViewModel(application) {

    private val autoCompletePublishSubjectEmail = PublishSubject.create<String>()
    private val autoCompletePublishSubjectPassword = PublishSubject.create<String>()
    private lateinit var loginObservable: LoginObservable
    private lateinit var easiestDB: EasiestDB

    init {
        configureInterceptor(autoCompletePublishSubjectEmail, 0)
            .subscribe { result -> filteredEmail(result) }
        configureInterceptor(autoCompletePublishSubjectPassword, 0)
            .subscribe { result -> filteredPassword(result) }
    }

    fun initDepdendencies(loginObservable: LoginObservable, easiestDB: EasiestDB) {
        this.loginObservable = loginObservable
        this.easiestDB = easiestDB
    }

    fun onEmailChange(text: CharSequence) {
        autoCompletePublishSubjectEmail.onNext(text.toString())
    }

    private fun filteredEmail(result: String) {
        this.loginObservable.apply {
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
        this.loginObservable.apply {
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
        when {
            find(easiestDB, loginObservable.email.get()!!, loginObservable.password.get()!!) -> Timber.d("Login success")
            else -> Timber.d("Login failed")
        }
    }

}