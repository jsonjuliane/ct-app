package wanda.weiss.ct_app

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import wanda.weiss.ct_app.di.DaggerAppComponent

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}