package com.wang.basemvvmkotlin.utils.common

import android.content.Context
import androidx.annotation.StringRes

/**
 * author: wtg  2019/4/24 0024
 * desc: 字符串处理类
 */
object StringUtils {
    /**
     * 只能传入String的id
     *
     * @param strId 资源id
     * @return 字符串
     */
    fun getString(context: Context, @StringRes strId: Int): String {
        return context.resources.getString(strId)
    }

    /**
     * 加密电话中间四位显示*
     *
     * @param mobile 手机号
     * @return 字符串
     */
    fun getEncodeMobile(mobile: String): String {
        return mobile.substring(
            0,
            mobile.length - mobile.substring(3).length
        ) + "****" + mobile.substring(7)
    }

    /**
     * 格式化字符串
     *
     * @param context 上下文
     * @param resId   字符资源id
     * @param args    参数
     * @return 字符串
     */
    fun strFormat(
        context: Context,
        @StringRes resId: Int,
        vararg args: Any?
    ): String {
        return String.format(
            getString(
                context,
                resId
            ), *args
        )
    }

    /**
     * 格式化字符串
     *
     * @param format 需要格式化的字符串
     * @param args   参数
     * @return 字符串
     */
    fun strFormat(format: String?, vararg args: Any?): String {
        return String.format(format!!, *args)
    }

    /**
     * 判断是否是gif图片
     *
     * @param path 图片路径
     * @return true 是 false 否
     */
    fun isGif(path: String): Boolean {
        return path.endsWith(".gif") || path.endsWith(".GIF")
    }

    /**
     * dp 转 px
     *
     * @param ctx 上下文
     * @param dp  dp
     * @return px
     */
    fun dp2px(ctx: Context, dp: Float): Int {
        val density = ctx.resources.displayMetrics.density
        return (dp * density + 0.5f).toInt() // 4.9->5 4.4->4
    }
}