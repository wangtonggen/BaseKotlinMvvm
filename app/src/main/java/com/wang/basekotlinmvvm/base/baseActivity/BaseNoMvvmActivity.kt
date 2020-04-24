package com.wang.basemvvmkotlin.base.baseActivity

import android.os.Bundle
import com.wang.basemvvmkotlin.constant.SwipeConstant

/**
 *
 * author: wtg
 * date:2020/4/23 0023
 * desc: 不使用mvvm的activity基类
 *
 */
abstract class BaseNoMvvmActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        initView()
    }
    override fun getEdgeTrackingEnabled(): Int {
        return SwipeConstant.SWIPE_LEFT_BACK
    }
}