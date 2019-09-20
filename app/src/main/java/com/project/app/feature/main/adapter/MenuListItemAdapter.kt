package com.project.app.feature.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.app.R
import com.project.app.databinding.ItemMenuBinding
import com.project.app.feature.addition.presentation.AdditionActivity
import com.project.app.feature.fibonacci.presentation.FibonacciActivity
import com.project.app.feature.multiplication.presentation.MultiplicationActivity
import com.project.app.feature.primary.presentation.PrimaryActivity
import com.project.data.entities.menu.MenuItem
import com.project.feature_alpha.presentation.AlphaActivity
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
            R.layout.item_menu, parent, false
        )
        return ViewHolder(parent.context, view)
    }

    class ViewHolder(context: Context, view: View) :
        BaseViewHolder<MenuItem>(context, view),
        MenuListItemView,
        ViewDataBindingOwner<ItemMenuBinding> {

        override lateinit var data: MenuItem
        override lateinit var binding: ItemMenuBinding
        private var viewModel: MenuListItemViewModel? = null

        init {
            binding.vm = MenuListItemViewModel()
            viewModel = binding.vm!!
        }

        override fun bindData() {
            viewModel?.bTextTitle?.set(data.title)

            data.imageUrl?.let { imageUrl ->
                GlideApp.with(context)
                    .load(imageUrl)
                    .thumbnail(0.1f)
                    .placeholder(R.drawable.bg_placeholder)
                    .error(R.drawable.bg_placeholder)
                    .into(binding.imgMenu)

                viewModel?.bShowImage?.set(true)
            }
        }

        override fun onClickItem(view: View) {
            when (data.id) {
                1 -> {
                    AdditionActivity.startThisActivity(context)
                }
                2 -> {
                    MultiplicationActivity.startThisActivity(context)
                }
                3 -> {
                    PrimaryActivity.startThisActivity(context)
                }
                4 -> {
                    FibonacciActivity.startThisActivity(context)
                }
                5 -> {
                    AlphaActivity.startThisActivity(context)
                }
            }
        }
    }
}