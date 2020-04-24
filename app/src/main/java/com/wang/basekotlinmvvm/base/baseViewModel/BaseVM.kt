package com.wang.basemvvmkotlin.base.baseViewModel

import android.view.View

/**
 *
 * author: wtg
 * date:2020/4/22 0022
 * desc: ViewModel基类
 *
 */
open class BaseVM {
    protected var TAG = javaClass.simpleName

    /**
     * View 的点击事件
     *
     * @param view view
     */
    fun onViewClick(view: View) {}
}