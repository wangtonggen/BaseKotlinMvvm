package com.wang.basemvvmkotlin.base.provider

import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wang.basekotlinmvvm.R
import com.wang.basemvvmkotlin.base.bean.LoginBean

/**
 *
 * author: wtg
 * date:2020/4/24 0024
 * desc:
 *
 */
class LoginProvider() : BaseProvider<LoginBean>() {
    override fun bindData(viewHolder: BaseViewHolder, data: LoginBean) {
        TODO("Not yet implemented")
    }

    override val itemViewType: Int
        get() = mData?.getItemType()!!
    override val layoutId: Int
        get() = R.layout.activity_main
}