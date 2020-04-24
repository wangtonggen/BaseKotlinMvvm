package com.wang.basemvvmkotlin.base.bean

/**
 *
 * author: wtg
 * date:2020/4/24 0024
 * desc: 多布局bean基类
 *
 */
abstract class ProviderMultiEntity {
    /**
     * 获取item的类型
     */
    abstract fun getItemType():Int
}