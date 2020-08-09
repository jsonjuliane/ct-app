package wanda.weiss.ct_app.di.module.app

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import wanda.weiss.ct_app.di.AppScope
import wanda.weiss.ct_app.model.config.Constants
import wanda.weiss.ct_app.model.network.ApiService

@Module(includes = [(NetworkModule::class), (DataModule::class)])
class ApiServiceModule {

    @Provides
    @AppScope
    fun getApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


    @Provides
    @AppScope
    fun getRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .baseUrl(Constants.BASE_URL)
            .build()
    }
}