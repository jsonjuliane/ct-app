package wanda.weiss.ct_app.view.login

import android.os.Bundle
import android.widget.Toast
import com.mukesh.countrypicker.CountryPicker
import com.mukesh.countrypicker.OnCountryPickerListener
import wanda.weiss.ct_app.R
import wanda.weiss.ct_app.databinding.ActivityLoginBinding
import wanda.weiss.ct_app.model.LocaleHelper
import wanda.weiss.ct_app.view.BaseActivity


class LoginActivity : BaseActivity<ActivityLoginBinding>(){
    private var picker: CountryPicker? = null
    private var pickerListener: OnCountryPickerListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind(this, R.layout.activity_login)

        binding.tvCountries.setOnClickListener { picker?.showDialog(this) }
    }

    override fun onStart() {
        super.onStart()
        pickerListener = OnCountryPickerListener {
            //it.code for country code
        }
        picker = CountryPicker.Builder().with(this).listener(pickerListener!!).build()
    }
}