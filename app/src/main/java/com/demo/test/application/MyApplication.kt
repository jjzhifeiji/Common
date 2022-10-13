package com.demo.test.application

import android.app.Application
import android.content.Context
import androidx.work.Configuration
import com.blankj.utilcode.util.Utils


open class MyApplication : Application(), Configuration.Provider {


    companion object {
        lateinit var appContext: Context
    }

    init {
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        initUtils()
        initAppViewModel()
        initTitleBar()
        initDataBase()
        initConstant()
        initHttp()
        initDebug()
        initUM()
        initFinish()
    }


    private fun initUtils() {
        Utils.init(this)
    }

    private fun initUM() {

    }


    private fun initFinish() {

    }

    private fun initAppViewModel() {
    }

    private fun initDebug() {
    }

    private fun initHttp() {

    }

    private fun initTitleBar() {
        // 初始化 TitleBar 样式
    }

    private fun initConstant() {
    }

    private fun initDataBase() {
    }

    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setDefaultProcessName("com.demo.test.background.multiprocess")
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .build()
}