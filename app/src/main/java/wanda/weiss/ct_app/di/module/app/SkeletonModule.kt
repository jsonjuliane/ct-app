package wanda.weiss.ct_app.di.module.app

import android.content.Context
import com.github.florent37.fiftyshadesof.FiftyShadesOf
import dagger.Module
import dagger.Provides
import wanda.weiss.ct_app.di.AppScope

@Module(includes = [AppModule::class])
class SkeletonModule {

    @Provides
    @AppScope
    fun getSkeleton(context: Context): FiftyShadesOf {
        return FiftyShadesOf.with(context)
    }

}