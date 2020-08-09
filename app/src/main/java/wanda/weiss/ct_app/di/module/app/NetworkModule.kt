package wanda.weiss.ct_app.di.module.app

import android.annotation.SuppressLint
import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Authenticator
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import wanda.weiss.ct_app.di.AppScope
import wanda.weiss.ct_app.model.config.Constants
import java.io.File
import java.util.concurrent.TimeUnit


@Module(includes = [LogModule::class, AppModule::class])
class NetworkModule {

    @SuppressLint("HardwareIds")
    @Provides
    @AppScope
    fun getInterceptor(context: Context): Interceptor {
        return Interceptor { chain ->
            val builder = chain.request().newBuilder().apply {}
            chain.proceed(builder.build())
        }
    }


    @Provides
    @AppScope
    fun getCacheFile(context: Context): File {
        return File(context.cacheDir, Constants.OKHTTP_CACHE)
    }

    @Provides
    @AppScope
    fun getCache(cacheFile: File): Cache {
        return Cache(cacheFile, (10 * 1000 * 1000).toLong()) //10 MB Cache
    }


    @Provides
    @AppScope
    fun getOkHttpClientBuilder(authenticator: Authenticator, httpLoggingInterceptor: HttpLoggingInterceptor,
                               cache: Cache, httpApiHeaders: Interceptor): OkHttpClient.Builder {

        return OkHttpClient.Builder()
                .authenticator(authenticator)
                .addInterceptor(httpApiHeaders)
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(Constants.NETWORK_TIMEOUT_SHORT, TimeUnit.SECONDS)
                .writeTimeout(Constants.NETWORK_TIMEOUT_SHORT, TimeUnit.SECONDS)
                .readTimeout(Constants.NETWORK_TIMEOUT, TimeUnit.SECONDS)
                .cache(cache)
    }

    @Provides
    @AppScope
    fun getOkHttpClient(okHttpclientBuilder: OkHttpClient.Builder): OkHttpClient {
        return okHttpclientBuilder.build()
    }

}