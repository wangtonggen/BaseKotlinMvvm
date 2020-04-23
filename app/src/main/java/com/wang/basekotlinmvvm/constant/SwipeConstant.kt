package com.wang.basekotlinmvvm.constant

import me.imid.swipebacklayout.lib.SwipeBackLayout

/**
 *
 *
 * author: wtg
 * date:2020/4/22 0022
 * desc: 滑动设置
 */
object SwipeConstant {
    const val SWIPE_LEFT_BACK = SwipeBackLayout.EDGE_LEFT//左滑
    const val SWIPE_RIGHT_BACK = SwipeBackLayout.EDGE_RIGHT//右滑
    const val SWIPE_BOTTOM_BACK = SwipeBackLayout.EDGE_BOTTOM//上划
    const val SWIPE_ALL_BACK = SwipeBackLayout.EDGE_ALL//所有方向
    const val SWIPE_NONE_BACK = -1//无效果
}