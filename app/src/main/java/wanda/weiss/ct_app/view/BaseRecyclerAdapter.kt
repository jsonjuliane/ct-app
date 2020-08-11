package wanda.weiss.ct_app.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

@Suppress("UNCHECKED_CAST")
abstract class BaseRecyclerAdapter<B : ViewDataBinding> :
    androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {
    open lateinit var binding: B
    private lateinit var context: Context

    fun bind(parent: ViewGroup, layout: Int): ViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, layout, parent, false)
        return ViewHolder(binding.root)
    }

    inner class ViewHolder(itemView: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView)
}