package com.zhifeiji.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.zhifeiji.common.R;

/**
 * @author: lijingzhe
 * @date: 2020/11/4
 * @desc:
 */
public class PrivacyAgreementDialog extends Dialog {


    public PrivacyAgreementDialog(Context context) {
        super(context);
    }

    public PrivacyAgreementDialog(Context context, int theme) {
        super(context, theme);
    }


    public static class Builder {
        private Context context;
        private PrivacyAgreementDialog.OnListener mListener;

        public Builder(Context context) {
            this.context = context;
        }

        public PrivacyAgreementDialog.Builder setListener(PrivacyAgreementDialog.OnListener listener) {
            mListener = listener;
            return this;
        }

        public PrivacyAgreementDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            final PrivacyAgreementDialog dialog = new PrivacyAgreementDialog(context, R.style.Dialog);
            View layout = inflater.inflate(R.layout.privacy_agreement_dialog, null);
            dialog.addContentView(layout, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            layout.findViewById(R.id.tv_confirm)
                    .setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            mListener.onConfirm(dialog);
                            dialog.dismiss();
                        }
                    });

            layout.findViewById(R.id.tv_cancel)
                    .setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            mListener.onCancel(dialog);
                            dialog.dismiss();
                        }
                    });


            dialog.setContentView(layout);
            return dialog;
        }

    }


    public interface OnListener {

        /**
         * 点击确定时回调
         */
        void onConfirm(Dialog dialog);

        /**
         * 点击取消时回调
         */
        default void onCancel(Dialog dialog) {
        }
    }

}
