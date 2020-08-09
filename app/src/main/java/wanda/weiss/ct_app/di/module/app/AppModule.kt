package wanda.weiss.ct_app.di.module.app

import android.content.Context
import dagger.Module
import dagger.Provides
import wanda.weiss.ct_app.App
import wanda.weiss.ct_app.di.AppScope

@Module
class AppModule {
    @Provides
    @AppScope
    fun provideContext(app: App): Context {
        return app
    }
}