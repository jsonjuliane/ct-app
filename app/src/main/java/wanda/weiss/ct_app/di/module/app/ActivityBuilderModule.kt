package wanda.weiss.ct_app.di.module.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import wanda.weiss.ct_app.di.module.login.LoginModule
import wanda.weiss.ct_app.view.login.LoginActivity

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun bindLogin(): LoginActivity
}