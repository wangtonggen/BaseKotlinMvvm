package com.wang.basemvvmkotlin.utils.system

import android.content.Context
import android.os.Build
import android.os.Looper
import android.os.Process
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.FileUtils
import com.blankj.utilcode.util.SDCardUtils
import com.wang.basemvvmkotlin.constant.FileConstant.DIR_CRASH
import com.wang.basemvvmkotlin.utils.common.LogUtils
import com.wang.basemvvmkotlin.utils.common.ToastUtils
import java.io.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * author: wtg
 * date:2020/4/22 0022
 * desc:
 *
 */
class CrashHandlerUtils private constructor() : Thread.UncaughtExceptionHandler{
    val TAG = "CrashHandlerUtils"
    //系统默认的UncaughtException处理类
    private var mDefaultHandler: Thread.UncaughtExceptionHandler? = null
    //程序的Context对象
    private var mContext: Context? = null
    //用来存储设备信息和异常信息
    private val infos: MutableMap<String, Any> = LinkedHashMap()
    //用于格式化日期,作为日志文件名的一部分
    private val formatter: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)
    //提示信息
    private var crashTip = "很抱歉,程序出现异常,即将退出."

    companion object {
        private var instance: CrashHandlerUtils? = null
            get() {
                if (field == null) {
                    field = CrashHandlerUtils()
                }
                return field
            }

        @Synchronized
        fun get(): CrashHandlerUtils {
            return instance!!
        }
    }

    fun init(context: Context) {
        mContext = context
        //获取系统默认的UncaughtException处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        //设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    fun getCrashTip(): String? {
        return crashTip
    }

    fun setCrashTip(crashTip: String) {
        this.crashTip = crashTip
    }

    override fun uncaughtException(thread: Thread, ex: Throwable) {
        if (!handleException(ex) && mDefaultHandler != null) {
            //如果用户没有处理则让系统默认的异常处理器来处理
            mDefaultHandler!!.uncaughtException(thread, ex)
        } else {
            try {
                Thread.sleep(3000)
            } catch (e: InterruptedException) {
                LogUtils.logE("error : ", e.message)
                e.printStackTrace()
            }
            //退出程序
            //退出JVM(java虚拟机),释放所占内存资源,0表示正常退出(非0的都为异常退出)
            AppUtils.exitApp()
            //从操作系统中结束掉当前程序的进程
            Process.killProcess(Process.myPid())
        }
    }

    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成.
     *
     * @param throwable 异常
     * @return true:如果处理了该异常信息;否则返回false.
     */
    private fun handleException(throwable: Throwable?): Boolean {
        if (throwable == null) {
            return false
        }
        //使用Toast来显示异常信息
        object : Thread() {
            override fun run() {
                Looper.prepare()
                throwable.printStackTrace()
                ToastUtils.showShortToast(getCrashTip())
                Looper.loop()
            }
        }.start()
        //收集设备参数信息
        collectDeviceInfo()
        //保存日志文件
        saveCrashInfo2File(throwable)
        return true
    }

    /**
     * 收集设备参数信息
     *
     */
    private fun collectDeviceInfo() {
        infos.put("app名称", AppUtils.getAppName())
        infos.put("versionCode", AppUtils.getAppVersionCode())
        infos.put("versionName", AppUtils.getAppVersionName())
        infos.put("sdk", Build.VERSION.SDK_INT)
        infos.put("androidVersion", Build.VERSION.RELEASE)
        val builderCpu = StringBuilder()
        for (supportedAbi in Build.SUPPORTED_ABIS) {
            builderCpu.append(supportedAbi)
            builderCpu.append(",")
        }
        infos.put("手机设备支持的cpu类型", builderCpu)
        infos.put("cpu_abi", Build.CPU_ABI)
        infos.put("cpu_abi2", Build.CPU_ABI2)
        infos.put("id", Build.ID)
        infos.put("device", Build.DEVICE)
        infos.put("品牌", Build.BRAND)
        infos.put("型号", Build.MODEL)
        infos.put("时间", formatter.format(Date()))
    }

    /**
     * 保存错误信息到文件中
     *
     * @param ex 异常
     */
    private fun saveCrashInfo2File(ex: Throwable) {
        val sb = StringBuilder()
        for ((key, value1) in infos.entries) {
            val value = value1.toString()
            sb.append(key).append("=").append(value).append("\n")
        }
        val writer: Writer = StringWriter()
        val printWriter = PrintWriter(writer)
        ex.printStackTrace(printWriter)
        var cause = ex.cause
        while (cause != null) {
            cause.printStackTrace(printWriter)
            cause = cause.cause
        }
        printWriter.close()
        val result = writer.toString()
        sb.append(result)
        LogUtils.logE(sb.toString())
        //        if(BuildConfig.DEBUG) {
//            return;
//        }
        /*
        这个 crashInfo 就是我们收集到的所有信息，可以做一个异常上报的接口用来提交用户的crash信息
         */
        val crashInfo = sb.toString()
        //写到sd卡上
        if (SDCardUtils.isSDCardEnableByEnvironment()) {
            FileUtils.createOrExistsDir(DIR_CRASH)
            val fileName: String = formatter.format(Date()) + ".txt"
            val crashFile = File(DIR_CRASH, fileName)
            FileUtils.createOrExistsFile(crashFile)
            try {
                val randomAccessFile =
                    RandomAccessFile(crashFile, "rwd")
                randomAccessFile.seek(crashFile.length())
                randomAccessFile.write(crashInfo.toByteArray())
                randomAccessFile.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        uploadCrashInfo(crashInfo)
    }

    /**
     * 上传crash信息 实现需要重写该方法
     *
     * @param crashInfo crash信息
     */
    fun uploadCrashInfo(crashInfo: String?) {
//        LogUtils.logE("info", crashInfo);
        //如果上传成功了，则删除，上传失败了,保留
    }
}