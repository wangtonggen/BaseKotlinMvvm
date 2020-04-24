package com.wang.basemvvmkotlin.base.baseFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * author: wtg
 * date:2020/3/21 0021
 * desc: 不适用mvvm的fragment的基类
 */
abstract class BaseNoMVVMFragment : BaseFragment() {
    protected var rootView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(mContext).inflate(layoutRes, container, false)
        initView(savedInstanceState, rootView)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}