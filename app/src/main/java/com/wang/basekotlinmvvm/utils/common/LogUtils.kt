package com.wang.basekotlinmvvm.utils.common

import android.util.Log
import com.wang.basekotlinmvvm.BuildConfig

/**
 * author: wtg
 * date:2020/3/13 0013
 * desc:
 */
object LogUtils {
    private const val TAG = "LogUtils"
    fun logE(tag: String?, message: String?) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message)
        }
    }

    fun logE(message: String?) {
        logE(
            TAG,
            message
        )
    }
}