package com.wang.basemvvmkotlin.utils.common

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import com.wang.basekotlinmvvm.base.app.BaseApplication

/**
 * 提示类
 */
object ToastUtils {
    /**
     * 长土司
     *
     * @param content 内容
     */
    fun showLongToast(content: String?) {
        showLongToast(
            BaseApplication.instance,
            content
        )
    }

    /**
     * 短土司
     *
     * @param content 内容
     */
    fun showShortToast(content: String?) {
        showShortToast(
            BaseApplication.instance,
            content
        )
    }

    /**
     * 短土司
     *
     * @param resId 字符串资源id
     */
    fun showShortToast(@StringRes resId: Int) {
        showShortToast(
            BaseApplication.instance,
            resId
        )
    }

    /**
     * 长时间显示吐司
     *
     * @param content 要显示的内容
     */
    fun showLongToast(context: Context?, content: String?) {
        Toast.makeText(
            context, content,
            Toast.LENGTH_LONG
        ).show()
    }

    /**
     * 短时间显示吐司
     *
     * @param content 显示的内容
     */
    fun showShortToast(context: Context?, content: String?) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
    }

    /**
     * 短时间显示吐司
     *
     * @param resId 资源id
     */
    fun showShortToast(context: Context, @StringRes resId: Int) {
        showShortToast(
            context,
            StringUtils.getString(context, resId)
        )
    }
}