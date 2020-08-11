package wanda.weiss.ct_app.di.module.app

import android.content.Context
import com.orhanobut.hawk.Hawk
import com.orhanobut.hawk.HawkBuilder
import dagger.Module
import dagger.Provides
import wanda.weiss.ct_app.di.AppScope

@Module
class PersistenceModule {
    @Provides
    @AppScope
    fun getHawk(context: Context): HawkBuilder {
        val hawkBuilder = Hawk.init(context)
        hawkBuilder.build()
        return hawkBuilder
    }
}