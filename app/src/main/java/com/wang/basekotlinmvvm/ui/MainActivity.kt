package com.wang.basekotlinmvvm.ui

import com.wang.basekotlinmvvm.BR
import com.wang.basekotlinmvvm.R
import com.wang.basekotlinmvvm.databinding.ActivityMainBinding
import com.wang.basemvvmkotlin.base.baseActivity.BaseSwipeBackActivity
import com.wang.basemvvmkotlin.constant.SwipeConstant
import com.wang.basemvvmkotlin.mvvm.viewModel.MainVM

/**
 * 主界面
 */
class MainActivity : BaseSwipeBackActivity<ActivityMainBinding, MainVM>() {
    override fun initView() {
        super.initView()
    }

    override fun getEdgeTrackingEnabled(): Int {
        return SwipeConstant.SWIPE_LEFT_BACK
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainVM {
        return MainVM(this)
    }

    override fun getViewModelId(): Int {
       return BR.mainVM
    }
}
