package com.wang.basekotlinmvvm.constant

import com.blankj.utilcode.util.SDCardUtils
import java.io.File

/**
 * author: wtg
 * date:2020/4/1 0001
 * desc: 文件的常量
 */
object FileConstant {
    //文件处理的根目录
    val DIR_ROOT = SDCardUtils.getSDCardPathByEnvironment() + File.separator + "luyuan"

    //apk的下载路径
    val DIR_APP = DIR_ROOT + File.separator + "app"

    //闪退文件的保存路径
    val DIR_CRASH = DIR_ROOT + File.separator + "crash"
}