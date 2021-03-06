package wanda.weiss.ct_app.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import wanda.weiss.ct_app.di.module.app.SkeletonModule
import wanda.weiss.ct_app.App
import wanda.weiss.ct_app.di.module.app.*

@AppScope
@Component(
    modules = [
        ActivityBuilderModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ApiServiceModule::class,
        AppModule::class,
        DataModule::class,
        SkeletonModule::class,
        LogModule::class,
        NetworkModule::class]
)

interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}