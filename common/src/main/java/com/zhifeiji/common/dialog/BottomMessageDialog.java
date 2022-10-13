package com.zhifeiji.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhifeiji.common.R;


/**
 * @author: lijingzhe
 * @date: 2020/11/4
 * @desc:
 */
public class BottomMessageDialog extends Dialog {


    public BottomMessageDialog(Context context) {
        super(context);
    }

    public BottomMessageDialog(Context context, int theme) {
        super(context, theme);
    }


    public static class Builder {
        private Context context;
        private String title = "";
        private String content = "";
        private BottomMessageDialog.OnListener mListener;

        public Builder(Context context) {
            this.context = context;
        }

        public BottomMessageDialog.Builder setTitle(String str) {
            title = str;
            return this;
        }

        public BottomMessageDialog.Builder setContent(String str) {
            content = str;
            return this;
        }

        public BottomMessageDialog.Builder setListener(BottomMessageDialog.OnListener listener) {
            mListener = listener;
            return this;
        }

        public BottomMessageDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            final BottomMessageDialog dialog = new BottomMessageDialog(context, R.style.BottomMessageDialog);
            View layout = inflater.inflate(R.layout.bottom_menu_dialog, null);
            dialog.addContentView(layout, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            ((TextView) layout.findViewById(R.id.tv_bottom_dialog_title)).setText(title);
            ((TextView) layout.findViewById(R.id.tv_bottom_dialog_content)).setText(content);
            layout.findViewById(R.id.tv_confirm)
                    .setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            mListener.onConfirm(dialog);
                            dialog.dismiss();
                        }
                    });

            dialog.setContentView(layout);
            dialog.getWindow().setGravity(Gravity.BOTTOM);
            dialog.getWindow().getAttributes().dimAmount = 0.7f;
            dialog.getWindow().setWindowAnimations(R.style.BottomAnimStyle);

            return dialog;
        }

    }

    public interface OnListener {

        /**
         * 点击确定时回调
         */
        void onConfirm(Dialog dialog);

    }

}
