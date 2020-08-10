package wanda.weiss.ct_app.di.module.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import dagger.android.DaggerApplication
import org.richit.easiestsqllib.EasiestDB
import wanda.weiss.ct_app.App
import wanda.weiss.ct_app.di.AppScope
import wanda.weiss.ct_app.di.module.app.DBModule
import wanda.weiss.ct_app.model.observable.login.LoginObservable
import wanda.weiss.ct_app.view.login.LoginActivity
import wanda.weiss.ct_app.viewmodel.login.LoginViewModel

@Module(includes = [DBModule::class])
class LoginModule{
    @Provides
    fun getLoginActivityVM(activity: LoginActivity, application: App): LoginViewModel {
        return ViewModelProviders.of(activity, LoginVMFactory(application))
            .get(LoginViewModel::class.java)
    }

    @Provides
    fun getLoginActivityObservable(): LoginObservable {
        return LoginObservable()
    }
}

@Suppress("UNCHECKED_CAST")
class LoginVMFactory(private val application: DaggerApplication) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(application) as T
    }

}