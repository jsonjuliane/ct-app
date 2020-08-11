package wanda.weiss.ct_app.viewmodel.content

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import dagger.android.DaggerApplication
import wanda.weiss.ct_app.model.pojo.ReturnUsers
import wanda.weiss.ct_app.model.repository.UsersRepository
import wanda.weiss.ct_app.viewmodel.BaseViewModel

@SuppressLint("CheckResult")
class ContentViewModel(application: DaggerApplication, private val usersRepository: UsersRepository) :
    BaseViewModel(application) {

    lateinit var returnUsers: LiveData<ReturnUsers>

    fun getUsers(){
        returnUsers = usersRepository.getUsers()
    }

}