package com.zhifeiji.common.view

import android.util.Log
import android.widget.Toast


object MyToast {

    private const val TAG = "ZHXToast"

    /**
     * 展示toast==LENGTH_SHORT
     *
     * @param msg
     */
    fun show(msg: String) {
        show(msg, Toast.LENGTH_SHORT)
    }

    /**
     * 展示toast==LENGTH_LONG
     *
     * @param msg
     */
    fun showLong(msg: String) {
        show(msg, Toast.LENGTH_LONG)
    }

    private fun show(massage: String, show_length: Int) {
        Log.d(TAG, "show: $massage $show_length")
    }
}