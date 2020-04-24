package com.wang.basemvvmkotlin.base.baseViewModel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.wang.basekotlinmvvm.R
import com.wang.basemvvmkotlin.base.baseActivity.BaseActivity

/**
 * author: wtg
 * date:2020/4/3 0003
 * desc: toolbar的基类
 */
class BaseToolbarActivityVM(mActivity: BaseActivity) :
    BaseActivityLifecycleVM(mActivity) {
    var toolbarColor: ObservableInt = ObservableInt(R.color.colorAccent) //toolbar 的颜色值
    var title = ObservableField("hello word") //标题
    var titleColor: ObservableInt = ObservableInt(R.color.color_title) //标题的颜色值
    var titleTextSize: ObservableInt = ObservableInt(R.dimen.size_text_title) //标题字体大小
    var titleShow = ObservableBoolean(true) //标题是否显示 true 显示 false不显示
    var rightText = ObservableField<String>() //右边文本
    var rightTextSize: ObservableInt = ObservableInt(R.dimen.size_text_title_right) //右边文字大小
    var rightTextColor: ObservableInt = ObservableInt(R.color.color_title_right) //右边文字颜色
    var rightTextShow = ObservableBoolean(false) //右边文本显示
    var rightImageResId = ObservableInt() //右边图标资源文件
    var rightImageShow = ObservableBoolean(false) //右侧图标是否显示
    var backNavigationShow = ObservableBoolean(true) //导航按钮是否显示
    var backNavigationResId: ObservableInt =
        ObservableInt(R.drawable.ic_navigate_before_black_24dp) //导航按钮资源文件
}