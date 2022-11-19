package com.demo.test.ui.share

import android.app.Activity
import android.os.Bundle
import com.hy.dihome.R
import com.zhifeiji.common.dialog.MessageDialog

class ShareActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        initView()
    }

    private fun initView() {

    }


    companion object {
        private const val TAG = "ShareActivity"
    }

}