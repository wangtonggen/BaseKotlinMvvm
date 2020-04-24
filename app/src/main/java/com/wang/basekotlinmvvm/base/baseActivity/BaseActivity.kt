package com.wang.basemvvmkotlin.base.baseActivity

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.wang.basemvvmkotlin.utils.common.ActivityManagerUtils
import me.imid.swipebacklayout.lib.app.SwipeBackActivity

/**
 *
 *
 * author: wtg
 * date:2020/4/22 0022
 * desc: activity基类
 */
abstract class BaseActivity : SwipeBackActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mSwipeBackLayout = swipeBackLayout
        mSwipeBackLayout.setEdgeTrackingEnabled(getEdgeTrackingEnabled())
        ActivityManagerUtils.get().addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityManagerUtils.get().finishActivity(this)
    }

    /**
     * 初始化控件
     */
    protected open fun initView() {}

    /**
     * activity 划出关闭的方向 SWIPE_LEFT_BACK 向右划出  SWIPE_RIGHT_BACK 向左划出  SWIPE_BOTTOM_BACK 向上划出 所有方向划出SWIPE_ALL_BACK 无效果SWIPE_NONE_BACK
     *
     * @return 方向
     */
    protected abstract fun getEdgeTrackingEnabled(): Int

    /**
     * 获取布局id
     *
     * @return layoutId
     */
    @LayoutRes
    protected abstract fun getLayoutRes(): Int
}