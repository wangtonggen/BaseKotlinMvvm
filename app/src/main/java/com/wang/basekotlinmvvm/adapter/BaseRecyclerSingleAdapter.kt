package com.wang.basemvvmkotlin.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * author: wtg
 * date:2020/3/23 0023
 * desc: 单布局的基类
 */
abstract class BaseRecyclerSingleAdapter<VB : ViewDataBinding, T, VH : BaseViewHolder>(layoutResId: Int, data: MutableList<T>) : BaseQuickAdapter<T, VH>(layoutResId, data) {

    override fun onItemViewHolderCreated(viewHolder: VH, viewType: Int) {
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView) //绑定数据
    }
    override fun convert(helper: VH, item: T) {
        val viewDataBinding = getViewDataBinding(helper)
        if (viewDataBinding != null) {
            bindData(helper, viewDataBinding, item)
            viewDataBinding.executePendingBindings()
        }
    }

    /**
     * 获取DataBinding 实例
     * @param vh viewHolder
     * @return DataBinding
     */
    private fun getViewDataBinding(vh: VH): VB? {
        return vh.getBinding()
    }

    /**
     * 设置数据源
     *
     * @param vh viewHolder
     * @param t  数据源
     */
    abstract fun bindData(vh: VH, viewDataBinding: VB, t: T)
}