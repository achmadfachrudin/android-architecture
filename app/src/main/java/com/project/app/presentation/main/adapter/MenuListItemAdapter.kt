package com.project.app.presentation.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.app.R
import com.project.app.databinding.ItemMenuBinding
import com.project.app.presentation.addition.AdditionActivity
import com.project.app.presentation.multiplication.MultiplicationActivity
import com.project.app.presentation.primary.PrimaryActivity
import com.project.data.entities.menu.MenuItem
import com.project.framework.core.BaseRecycleViewAdapter
import com.project.framework.core.BaseViewHolder
import com.project.framework.core.GlideApp
import com.project.framework.core.owner.ViewDataBindingOwner

/**
 * Created by achmad.fachrudin on 3-Jun-19
 */
class MenuListItemAdapter : BaseRecycleViewAdapter<MenuItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MenuItem> {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_menu, parent, false)
        return ViewHolder(parent.context, view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<MenuItem>, position: Int) {
        (holder as ViewHolder).bindData(getItem(position))
    }

    class ViewHolder(context: Context, view: View) :
        BaseViewHolder<MenuItem>(context, view),
        MenuListItemView,
        ViewDataBindingOwner<ItemMenuBinding> {

        override lateinit var binding: ItemMenuBinding
        private var viewModel: MenuListItemViewModel? = null
        private var data: MenuItem? = null

        init {
            binding.vm = MenuListItemViewModel()
            binding.view = this
            viewModel = binding.vm
        }

        override fun bindData(data: MenuItem) {
            this.data = data

            data.let {
                viewModel?.bTextTitle?.set(it.title)

                it.imageUrl?.let { imageUrl ->
                    GlideApp.with(context)
                        .load(imageUrl)
                        .thumbnail(0.1f)
                        .placeholder(R.drawable.bg_placeholder)
                        .error(R.drawable.bg_placeholder)
                        .into(binding.imgMenu)

                    viewModel?.bShowImage?.set(true)
                }
            }
        }

        override fun onClickMenu(view: View) {
            data?.let {
                when (it.id) {
                    1 -> {
                        AdditionActivity.startThisActivity(context)
                    }
                    2 -> {
                        MultiplicationActivity.startThisActivity(context)
                    }
                    3 -> {
                        PrimaryActivity.startThisActivity(context)
                    }
                }
            }
        }
    }
}