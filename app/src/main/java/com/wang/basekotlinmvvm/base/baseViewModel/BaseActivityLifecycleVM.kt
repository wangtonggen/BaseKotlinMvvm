package com.wang.basemvvmkotlin.base.baseViewModel

import android.os.Bundle
import android.view.View
import com.wang.basemvvmkotlin.base.baseActivity.BaseActivity

/**
 * author: wtg
 * date:2020/3/13 0013
 * desc: ViewModel的基类 activity
 */
abstract class BaseActivityLifecycleVM(mActivity: BaseActivity) : BaseLifecycleVM() {
    protected var mActivity: BaseActivity = mActivity
    protected var myBundle: Bundle? = null

    /**
     * 设置 bundle 传递数据
     *
     * @param bundle bundle
     */
    fun setBundle(bundle: Bundle?) {
        this.myBundle = bundle
    }

    /**
     * 点击返回键 功能
     *
     * @param view view
     */
    fun onBackClick(view: View?) {
        mActivity.finish()
    }

}