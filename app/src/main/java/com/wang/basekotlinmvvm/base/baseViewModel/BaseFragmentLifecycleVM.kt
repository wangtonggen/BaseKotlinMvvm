package com.wang.basekotlinmvvm.base.baseViewModel

import android.content.Context
import com.wang.basekotlinmvvm.base.baseFragment.BaseFragment

/**
 * author: wtg
 * date:2020/3/13 0013
 * desc: ViewModel的基类 fragment
 */
abstract class BaseFragmentLifecycleVM(fragment: BaseFragment) : BaseLifecycleVM() {
    protected var mFragment: BaseFragment = fragment
    protected var mContext: Context? = fragment.context

    /**
     * 初始化
     */
    protected fun init() {}
}