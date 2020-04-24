package com.wang.basemvvmkotlin.base.baseViewModel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *
 * author: wtg
 * date:2020/4/22 0022
 * desc: 带生命周期的ViewModel的基类
 */
abstract class BaseLifecycleVM : BaseVM(),LifecycleObserver{
    private var mDisposables: CompositeDisposable = CompositeDisposable() //请求管理类

    /**
     * 加入订阅对象
     *
     * @param disposable 订阅对象
     */
    protected open fun addDisposable(disposable: Disposable?) {
        if (mDisposables.isDisposed) {
            mDisposables = CompositeDisposable()
        }
        mDisposables.add(disposable!!)
    }

    /**
     * 取消所有请求
     */
    private fun cancelRequest() {
        if (mDisposables.size() > 0 && !mDisposables.isDisposed) mDisposables.dispose()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {
//        LogUtils.logE(TAG, "onCreate: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {
//        LogUtils.logE(TAG, "onStart: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() {
//        LogUtils.logE(TAG, "onResume: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun onPause() {
//        LogUtils.logE(TAG, "onPause: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {
//        LogUtils.logE(TAG, "onStop: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
//        LogUtils.logE(TAG, "onDestroy: ");
        cancelRequest()
    }
}