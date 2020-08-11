package wanda.weiss.ct_app.model.repository

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import wanda.weiss.ct_app.App
import wanda.weiss.ct_app.model.pojo.ReturnUsers

class UsersRepository(private val app: App) {
    var returnUsers = MutableLiveData<ReturnUsers>()

    @SuppressLint("CheckResult")
    fun getUsers(): MutableLiveData<ReturnUsers> {
        app.apiService.getUsers()

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                returnUsers.postValue(ReturnUsers(it, null))
            }, {
                returnUsers.postValue(ReturnUsers(null, it))
            })
        return returnUsers
    }

}