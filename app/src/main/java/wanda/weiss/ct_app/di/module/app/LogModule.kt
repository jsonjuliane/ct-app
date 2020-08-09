package wanda.weiss.ct_app.di.module.app

import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import wanda.weiss.ct_app.BuildConfig
import wanda.weiss.ct_app.di.AppScope

@Module(includes = [AppModule::class])
class LogModule {
    @AppScope
    @Provides
    fun provideLogTree(): Timber.Tree {
        return Timber.DebugTree()
    }

    @AppScope
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(when {
            BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
            else -> HttpLoggingInterceptor.Level.NONE
        })
    }
}

