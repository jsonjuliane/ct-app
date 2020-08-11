package wanda.weiss.ct_app.view.content

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import wanda.weiss.ct_app.R
import wanda.weiss.ct_app.databinding.ActivityContentBinding
import wanda.weiss.ct_app.view.BaseActivity

class ContentActivity: BaseActivity<ActivityContentBinding>(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind(this, R.layout.activity_content)
    }

    override fun onStart() {
        super.onStart()
        binding.rvUsers.apply {
            layoutManager = LinearLayoutManager(this@ContentActivity, LinearLayoutManager.VERTICAL, false)
            adapter = UsersAdapter()
        }
    }

}