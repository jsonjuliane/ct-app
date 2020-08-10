package wanda.weiss.ct_app.di.module.app

import dagger.Module
import dagger.Provides
import org.richit.easiestsqllib.EasiestDB
import wanda.weiss.ct_app.App
import wanda.weiss.ct_app.di.AppScope

@Module(includes = [AppModule::class])
class DBModule {
    @Provides
    @AppScope
    fun provideDB(app: App): EasiestDB {
        return EasiestDB.init(app)
    }
}