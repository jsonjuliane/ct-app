package wanda.weiss.ct_app.view.content

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import timber.log.Timber
import wanda.weiss.ct_app.R
import wanda.weiss.ct_app.databinding.ActivityContentBinding
import wanda.weiss.ct_app.model.pojo.Users
import wanda.weiss.ct_app.view.BaseActivity
import wanda.weiss.ct_app.viewmodel.content.ContentViewModel
import javax.inject.Inject

class ContentActivity: BaseActivity<ActivityContentBinding>(){

    @Inject
    lateinit var vm: ContentViewModel

    private val usersList = ArrayList<Users>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind(this, R.layout.activity_content)
        binding.contentActivityVM = vm
    }

    override fun onStart() {
        super.onStart()
        binding.rvUsers.apply {
            layoutManager = LinearLayoutManager(this@ContentActivity, LinearLayoutManager.VERTICAL, false)
            adapter = UsersAdapter(usersList)
        }

        vm.getUsers()
        vm.returnUsers.observe(this, Observer {
            when {
                it.error!=null -> {

                }
                else -> {
                    usersList.addAll(it.users!!)
                    binding.rvUsers.adapter?.notifyDataSetChanged()
                }
            }
        })
    }

}