package wanda.weiss.ct_app.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import dagger.android.DaggerApplication
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit


open class BaseViewModel(application: DaggerApplication) : AndroidViewModel(application) {
    fun configureInterceptor(autoCompletePublishSubject: PublishSubject<String>, timeout: Long): Observable<String> {

        return autoCompletePublishSubject
            .debounce(timeout, TimeUnit.MILLISECONDS)
            .filter { text -> !text.isEmpty() }
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }
}