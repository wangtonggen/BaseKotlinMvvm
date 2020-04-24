package com.wang.basemvvmkotlin.base.baseFragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * author: wtg
 * date:2020/3/21 0021
 * desc: fragment基类
 */
abstract class BaseFragment : Fragment() {
    protected var TAG = this.javaClass.simpleName
    protected var mContext: Context? = null
    protected var mActivity: Activity? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        mActivity = activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            getBundleArgument(arguments)
        }
    }

    /**
     * 用newInstance创建 fragment 获取参数
     *
     * @param bundle bundle
     */
    fun getBundleArgument(bundle: Bundle?) {}
    protected fun initView(
        savedInstanceState: Bundle?,
        rootView: View?
    ) {
    }

    @get:LayoutRes
    protected abstract val layoutRes: Int
}