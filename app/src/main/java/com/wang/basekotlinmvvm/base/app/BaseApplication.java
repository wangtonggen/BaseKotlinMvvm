package com.wang.basekotlinmvvm.base.app;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.wang.basekotlinmvvm.R;
import com.wang.basekotlinmvvm.utils.system.CrashHandlerUtils;

/**
 * author: wtg
 * date:2020/3/12 0012
 * desc:
 */
public class BaseApplication extends MultiDexApplication {
    public static Application instance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        instance = this;
        //初始化下拉刷新，上拉加载 的头部和尾部
        initSmartRefreshHeaderAndFooter();
        //初始化全局carsh
        CrashHandlerUtils.Companion.get().init(this);
    }

    /**
     * 全局初始化下拉刷新上拉加载的头部和尾部
     */
    private void initSmartRefreshHeaderAndFooter() {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> {
            layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
            return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> {
            return new ClassicsFooter(context).setDrawableSize(20);
        });
    }
}
