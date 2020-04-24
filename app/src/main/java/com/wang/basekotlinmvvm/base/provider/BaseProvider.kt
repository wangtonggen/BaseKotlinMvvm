package com.wang.basemvvmkotlin.base.provider

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wang.basemvvmkotlin.base.bean.ProviderMultiEntity

/**
 *
 * author: wtg
 * date:2020/4/24 0024
 * desc: 多布局负责业务的的处理
 *
 */
abstract class BaseProvider<T:ProviderMultiEntity> : BaseItemProvider<T>() {
    protected var mData:T?=null
    override fun onViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ViewDataBinding>(viewHolder.itemView) //绑定数据
    }

    override fun convert(helper: BaseViewHolder, data: T) {
        mData = data
        bindData(helper, data)
        helper.getBinding<ViewDataBinding>()!!.executePendingBindings()
    }

    /**
     * 设置数据源
     *
     * @param viewHolder viewHolder
     * @param data  数据源
     */
    abstract fun bindData(viewHolder: BaseViewHolder, data: T)
}