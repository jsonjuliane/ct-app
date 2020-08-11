package wanda.weiss.ct_app.view.content

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import wanda.weiss.ct_app.R
import wanda.weiss.ct_app.databinding.ItemUserBinding
import wanda.weiss.ct_app.view.BaseRecyclerAdapter

class UsersAdapter(): BaseRecyclerAdapter<ItemUserBinding>(){
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = bind(parent, R.layout.item_user)
        this.context = parent.context
        return viewHolder
    }


    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = position
    }

}