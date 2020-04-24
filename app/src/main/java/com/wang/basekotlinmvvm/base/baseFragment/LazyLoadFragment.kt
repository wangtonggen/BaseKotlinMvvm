package com.wang.basemvvmkotlin.base.baseFragment

import androidx.databinding.ViewDataBinding
import com.wang.basemvvmkotlin.base.baseViewModel.BaseLifecycleVM

/**
 * author: wtg
 * date:2020/3/17 0017
 * desc: 懒加载
 */
abstract class LazyLoadFragment<B : ViewDataBinding, VM : BaseLifecycleVM> : BaseMVVMFragment<B, VM>() {
    private var isFirstLoad = true //是否是第一次加载 true是 false 否
    override fun onResume() {
        super.onResume()
        //懒加载 加载数据
        if (isFirstLoad) {
            isFirstLoad = false
            onLazyLoadData()
        }
    }

    //加载数据
    abstract fun onLazyLoadData()
}