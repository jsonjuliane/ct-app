package wanda.weiss.ct_app

import com.github.florent37.fiftyshadesof.FiftyShadesOf
import com.google.gson.Gson
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import wanda.weiss.ct_app.di.DaggerAppComponent
import wanda.weiss.ct_app.model.network.ApiService
import javax.inject.Inject

class App : DaggerApplication() {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var skeleton: FiftyShadesOf

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}