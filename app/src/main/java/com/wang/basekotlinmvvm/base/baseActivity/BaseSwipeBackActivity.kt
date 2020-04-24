package com.wang.basemvvmkotlin.base.baseActivity

import androidx.databinding.ViewDataBinding
import com.wang.basemvvmkotlin.base.baseViewModel.BaseLifecycleVM
import com.wang.basemvvmkotlin.constant.SwipeConstant

/**
 *
 * author: wtg
 * date:2020/4/23 0023
 * desc: 右滑关闭的activity基类
 *
 */
abstract class BaseSwipeBackActivity<B : ViewDataBinding, VM : BaseLifecycleVM> : BaseMvvmActivity<B,VM>(){

    override fun getEdgeTrackingEnabled(): Int {
        return SwipeConstant.SWIPE_LEFT_BACK
    }
}