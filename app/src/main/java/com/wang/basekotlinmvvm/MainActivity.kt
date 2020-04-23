package com.wang.basekotlinmvvm

import com.wang.basekotlinmvvm.base.baseActivity.BaseSwipeBackActivity
import com.wang.basekotlinmvvm.constant.SwipeConstant
import com.wang.basekotlinmvvm.databinding.ActivityMainBinding
import com.wang.basekotlinmvvm.mvvm.viewModel.MainVM

/**
 * 主界面
 */
class MainActivity : BaseSwipeBackActivity<ActivityMainBinding,MainVM>() {
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
