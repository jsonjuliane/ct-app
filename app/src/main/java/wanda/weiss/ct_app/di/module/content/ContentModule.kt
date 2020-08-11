package wanda.weiss.ct_app.di.module.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import dagger.android.DaggerApplication
import wanda.weiss.ct_app.App
import wanda.weiss.ct_app.model.repository.UsersRepository
import wanda.weiss.ct_app.view.content.ContentActivity
import wanda.weiss.ct_app.viewmodel.content.ContentViewModel

@Module
class ContentModule {
    @Provides
    fun getUsersRepository(application: App): UsersRepository {
        return UsersRepository(application)
    }

    @Provides
    fun getContentActivityVM(activity: ContentActivity, application: App, usersRepository: UsersRepository): ContentViewModel {
        return ViewModelProviders.of(activity, ContentVMFactory(application, usersRepository))
            .get(ContentViewModel::class.java)
    }
}

@Suppress("UNCHECKED_CAST")
class ContentVMFactory(
    private val application: DaggerApplication,
    private val usersRepository: UsersRepository
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ContentViewModel(application, usersRepository) as T
    }

}