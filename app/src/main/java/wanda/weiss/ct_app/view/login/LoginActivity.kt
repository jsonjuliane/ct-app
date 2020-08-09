package wanda.weiss.ct_app.view.login

import android.os.Bundle
import wanda.weiss.ct_app.R
import wanda.weiss.ct_app.databinding.ActivityLoginBinding
import wanda.weiss.ct_app.view.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind(this, R.layout.activity_login)
    }
}