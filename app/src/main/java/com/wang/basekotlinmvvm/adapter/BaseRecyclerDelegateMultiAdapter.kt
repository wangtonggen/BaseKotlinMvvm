package com.wang.basemvvmkotlin.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseDelegateMultiAdapter
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 *
 * author: wtg
 * date:2020/4/24 0024
 * desc: 如果数据类无法实现[MultiItemEntity] 多布局文件
 *
 */
abstract class BaseRecyclerDelegateMultiAdapter<T, VH : BaseViewHolder>(data: MutableList<T>) :
    BaseDelegateMultiAdapter<T, VH>(data) {
    init {
        setMultiTypeDelegate(getBaseMultiTypeDelegate())
        bindMultiType()
    }
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

    /**
     * 获取代理
     */
    abstract fun getBaseMultiTypeDelegate():BaseMultiTypeDelegate<T>

    /**
     * 绑定 多item类型
     */
    abstract fun bindMultiType();
}