package com.wyh.financialbook.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import com.wyh.financialbook.MainConfig;
import com.wyh.financialbook.R;

public class MainActivity extends AppCompatActivity {
    private TextView tv_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initAccount();
    }

    private void initView() {
        tv_account = findViewById(R.id.tv_account);
        tv_account.setText(getString(R.string.not_logged_in));
    }

    private void initAccount() {
        String account = MainConfig.newInstance().getAccount();
        if (!TextUtils.isEmpty(account)) {
            tv_account.setText(account);
        }
    }
}
