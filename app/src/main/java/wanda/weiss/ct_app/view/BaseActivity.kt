package wanda.weiss.ct_app.view

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.github.florent37.fiftyshadesof.FiftyShadesOf
import com.google.gson.Gson
import dagger.android.support.DaggerAppCompatActivity
import wanda.weiss.ct_app.model.network.ApiService
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding> : DaggerAppCompatActivity() {
    open lateinit var binding: B
    fun bind(activity: DaggerAppCompatActivity, @LayoutRes layout: Int) {
        binding = DataBindingUtil.setContentView(activity, layout)
    }
}