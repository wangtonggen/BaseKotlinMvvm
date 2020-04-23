package com.wang.basekotlinmvvm.base.baseActivity

import androidx.databinding.ViewDataBinding
import com.wang.basekotlinmvvm.base.baseViewModel.BaseLifecycleVM
import com.wang.basekotlinmvvm.constant.SwipeConstant

/**
 *
 * author: wtg
 * date:2020/4/23 0023
 * desc:无滑动关闭的activity基类
 *
 */
abstract class BaseNoneSwipeActivity<B : ViewDataBinding, VM : BaseLifecycleVM> : BaseMvvmActivity<B,VM>(){

    override fun getEdgeTrackingEnabled(): Int {
        return SwipeConstant.SWIPE_NONE_BACK
    }
}