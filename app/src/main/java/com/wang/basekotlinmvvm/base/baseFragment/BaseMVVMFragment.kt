package com.wang.basekotlinmvvm.base.baseFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.wang.basekotlinmvvm.base.baseViewModel.BaseLifecycleVM

/**
 * author: wtg
 * date:2020/3/12 0012
 * desc: fragment 基类
 */
abstract class BaseMVVMFragment<B : ViewDataBinding, VM : BaseLifecycleVM> : BaseFragment() {
    protected var binding: B? = null
    protected var myViewModelId = 0
    protected var myViewModel: VM? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        initView(savedInstanceState, binding?.root)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //view 创建之后
        myViewModelId = getViewModelId()
        myViewModel = getViewModel()
        refreshLayout()
        lifecycle.addObserver(myViewModel!!)
    }

    private fun refreshLayout() {
        if (myViewModel != null) {
            binding!!.setVariable(myViewModelId, myViewModel)
        }
    }

    /**
     * 获取viewModel
     *
     * @return viewModel
     */
    protected abstract fun getViewModel(): VM

    /**
     * 获取BR的id
     *
     * @return id
     */
    protected abstract fun getViewModelId(): Int
}