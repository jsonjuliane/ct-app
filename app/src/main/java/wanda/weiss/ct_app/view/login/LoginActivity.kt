package wanda.weiss.ct_app.view.login

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
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
    lateinit var obs: LoginObservable

    @Inject
    lateinit var vm: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind(this, R.layout.activity_login)
        binding.loginActivityVM = vm
        binding.loginObservable = obs
        vm.initDepdendencies(obs, (application as App).easiestDB)
    }

    override fun onStart() {
        super.onStart()
        pickerListener = OnCountryPickerListener {
        }
        picker = CountryPicker.Builder().with(this).listener(pickerListener!!).build()
        //        binding.tvCountries.setOnClickListener { picker?.showDialog(this) }

        vm.success.observe(this, Observer {
            if(it){
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}