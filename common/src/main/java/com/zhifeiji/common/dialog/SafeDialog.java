package com.zhifeiji.common.dialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zhifeiji.common.R;


/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2020/02/06
 *    desc   : 身份校验对话框
 */
public final class SafeDialog {

    public static final class Builder
            extends UIDialog.Builder<Builder> {

        private final TextView mPhoneView;
        private final EditText mCodeView;
        private final CountdownView mCountdownView;

        private OnListener mListener;

        /** 当前手机号 */
        private final String mPhoneNumber;

        public Builder(Context context) {
            super(context);
            setTitle(R.string.safe_title);
            setCustomView(R.layout.safe_dialog);
            mPhoneView = findViewById(R.id.tv_safe_phone);
            mCodeView = findViewById(R.id.et_safe_code);
            mCountdownView = findViewById(R.id.cv_safe_countdown);
            setOnClickListener(mCountdownView);

            mPhoneNumber = "18100001413";
            // 为了保护用户的隐私，不明文显示中间四个数字
            mPhoneView.setText(String.format("%s****%s", mPhoneNumber.substring(0, 3), mPhoneNumber.substring(mPhoneNumber.length() - 4)));
        }

        public Builder setCode(String code) {
            mCodeView.setText(code);
            return this;
        }

        public Builder setListener(OnListener listener) {
            mListener = listener;
            return this;
        }

        @Override
        public void onClick(View v) {

        }
    }

    public interface OnListener {

        /**
         * 点击确定时回调
         */
        void onConfirm(BaseDialog dialog, String phone, String code);

        /**
         * 点击取消时回调
         */
        default void onCancel(BaseDialog dialog) {}
    }
}