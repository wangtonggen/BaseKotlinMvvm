package com.wang.basemvvmkotlin.utils.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 *
 *
 * author: wtg
 * date:2020/4/22 0022
 * desc: activity 管理的工具类
 */
class ActivityManagerUtils private constructor() {
    // Activity栈
    private val activityStack = Stack<Activity?>()

    // 单例模式
    private val TAG = javaClass.simpleName

    companion object {
        private var instance: ActivityManagerUtils? = null
            get() {
                if (field == null) {
                    field =
                        ActivityManagerUtils()
                }
                return field
            }

        @Synchronized
        fun get(): ActivityManagerUtils {
            return instance!!
        }
    }

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity?) {
        activityStack.add(activity)
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity(): Activity? {
        return if (activityStack.size == 0) null else activityStack.lastElement()
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishCurrentActivity() {
        if (activityStack.size != 0) {
            val activity = activityStack.lastElement()
            finishActivity(activity)
        }
    }

    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity: Activity?) {
        if (activity != null && activityStack.contains(activity)) {
            activityStack.remove(activity)
            activity.finish()
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        var i = 0
        while (i < activityStack.size) {
            if (activityStack[i]!!.javaClass == cls) {
                finishActivity(activityStack[i])
                i--
            }
            i++
        }
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        for (i in activityStack.indices) {
            if (null != activityStack[i]) {
                activityStack[i]!!.finish()
            }
        }
        activityStack.clear()
    }

    /**
     * 关闭之前的activity
     */
    fun finishBeforeAllActivity() {
        var i = 0
        while (i < activityStack.size - 1) {
            if (null != activityStack[i]) {
                activityStack[i]!!.finish()
                activityStack.removeAt(i)
                i--
            }
            i++
        }
    }

    /**
     * 关闭第一个之后的的activity
     */
    fun finishAfterAllActivity() {
        var i = 1
        while (i < activityStack.size) {
            if (null != activityStack[i]) {
                activityStack[i]!!.finish()
                activityStack.removeAt(i)
                i--
            }
            i++
        }
    }

    /**
     * 退出应用程序
     */
    fun AppExit(context: Context) {
        try {
            finishAllActivity()
            val activityMgr = context
                .getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            activityMgr.killBackgroundProcesses(context.packageName)
            System.exit(0)
        } catch (e: Exception) {
//            LogUtils.e(TAG, e.getMessage());
        }
    }
}