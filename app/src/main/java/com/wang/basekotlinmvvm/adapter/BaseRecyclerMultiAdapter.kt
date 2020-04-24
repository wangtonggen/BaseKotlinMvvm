package com.wang.basemvvmkotlin.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * 适用于类型较少，业务不复杂的场景，便于快速使用。
 * author: wtg
 * date:2020/3/23 0023
 * desc: 多布局的基类
 */
abstract class BaseRecyclerMultiAdapter<T : MultiItemEntity, VH : BaseViewHolder>(data: MutableList<T>) : BaseMultiItemQuickAdapter<T, VH>(data) {

    override fun onItemViewHolderCreated(viewHolder: VH, viewType: Int) {
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView) //绑定数据
    }

    override fun convert(helper: VH, item: T) {
        bindData(helper, item)
        helper.getBinding<ViewDataBinding>()!!.executePendingBindings()
    }

    /**
     * 设置数据源
     *
     * @param vh viewHolder
     * @param t  数据源
     */
    abstract fun bindData(vh: VH, t: T)
}