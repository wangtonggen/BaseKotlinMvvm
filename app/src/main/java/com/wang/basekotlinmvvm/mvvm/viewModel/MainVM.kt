package com.wang.basemvvmkotlin.mvvm.viewModel

import androidx.databinding.ObservableField
import com.wang.basemvvmkotlin.base.baseActivity.BaseActivity
import com.wang.basemvvmkotlin.base.baseViewModel.BaseActivityLifecycleVM

/**
 *
 * author: wtg
 * date:2020/4/23 0023
 * desc:
 *
 */
class MainVM: BaseActivityLifecycleVM{
    var text:ObservableField<String> = ObservableField()
    constructor(mActivity: BaseActivity) : super(mActivity) {
        text.set("hello 你好")
    }

}