package wanda.weiss.ct_app

import com.github.florent37.fiftyshadesof.FiftyShadesOf
import com.google.gson.Gson
import com.orhanobut.hawk.HawkBuilder
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import org.richit.easiestsqllib.EasiestDB
import timber.log.Timber
import wanda.weiss.ct_app.di.DaggerAppComponent
import wanda.weiss.ct_app.model.network.ApiService
import wanda.weiss.ct_app.model.util.init
import javax.inject.Inject


class App : DaggerApplication() {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var easiestDB: EasiestDB

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var skeleton: FiftyShadesOf

    @Inject
    lateinit var timberDebugTree: Timber.Tree

    @Inject
    lateinit var hawk: HawkBuilder

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(timberDebugTree)
        hawk.build()
        init(easiestDB)
    }
}