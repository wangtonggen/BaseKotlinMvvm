package com.wang.basemvvmkotlin.base.baseActivity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.wang.basemvvmkotlin.base.baseViewModel.BaseLifecycleVM

/**
 *
 * author: wtg
 * date:2020/4/23 0023
 * desc: mvvm activity基类
 *
 */
abstract class BaseMvvmActivity<B : ViewDataBinding, VM : BaseLifecycleVM> : BaseActivity(){
    protected var binding: B? = null
    protected var myViewModelId = 0
    protected var myViewModel: VM? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,getLayoutRes())
        myViewModel = getViewModel()
        myViewModelId = getViewModelId()
        refreshLayout()
        lifecycle.addObserver(myViewModel!!) //监听生命周期
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.unbind()
    }

    /**
     * 刷新布局
     */
    protected open fun refreshLayout() {
        if (myViewModel != null) {
            binding!!.setVariable(myViewModelId, myViewModel)
        }
    }


    /**
     * 获取viewModel
     *
     * @return viewModel
     */
    protected abstract fun getViewModel(): VM

    /**
     * 获取BR的id
     *
     * @return id
     */
    protected abstract fun getViewModelId(): Int
}