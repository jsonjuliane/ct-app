package wanda.weiss.ct_app.di.module.app

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import wanda.weiss.ct_app.di.AppScope

@Module
class DataModule {
    val gson: Gson
        @Provides
        @AppScope
        get() = GsonBuilder()
            .setPrettyPrinting()
            .create()
}