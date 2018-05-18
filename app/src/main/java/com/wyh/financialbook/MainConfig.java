package com.wyh.financialbook;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wyh on 18-5-18
 */
public class MainConfig {
    private SharedPreferences config;

    private static MainConfig instance = null;

    private static final String ACCOUNT_NAME = "name";

    private MainConfig() {
        config = BaseApplication.getContext().getSharedPreferences("main_config", Context.MODE_PRIVATE);
    }

    public static MainConfig newInstance() {
        if (null == instance) {
            instance = new MainConfig();
        }
        return instance;
    }

    public void setAccount(String name) {
        config.edit().putString(ACCOUNT_NAME, name).apply();
    }

    public String getAccount() {
        return config.getString(ACCOUNT_NAME, "");
    }
}
