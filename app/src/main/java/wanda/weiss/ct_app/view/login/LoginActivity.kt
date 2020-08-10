package wanda.weiss.ct_app.view.login

import android.os.Bundle
import com.mukesh.countrypicker.CountryPicker
import com.mukesh.countrypicker.OnCountryPickerListener
import wanda.weiss.ct_app.App
import wanda.weiss.ct_app.R
import wanda.weiss.ct_app.databinding.ActivityLoginBinding
import wanda.weiss.ct_app.model.observable.login.LoginObservable
import wanda.weiss.ct_app.view.BaseActivity
import wanda.weiss.ct_app.viewmodel.login.LoginViewModel
import javax.inject.Inject


class LoginActivity : BaseActivity<ActivityLoginBinding>(){
    private var picker: CountryPicker? = null
    private var pickerListener: OnCountryPickerListener? = null

    @Inject
    lateinit var loginObservable: LoginObservable

    @Inject
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind(this, R.layout.activity_login)
        binding.loginActivityVM = loginViewModel
        binding.loginObservable = loginObservable
        loginViewModel.initDepdendencies(loginObservable, (application as App).easiestDB)
    }

    override fun onStart() {
        super.onStart()
        pickerListener = OnCountryPickerListener {
        }
        picker = CountryPicker.Builder().with(this).listener(pickerListener!!).build()
        //        binding.tvCountries.setOnClickListener { picker?.showDialog(this) }
    }
}