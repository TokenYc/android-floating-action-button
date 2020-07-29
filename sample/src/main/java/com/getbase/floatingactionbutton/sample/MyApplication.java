package com.getbase.floatingactionbutton.sample;

import android.app.Application;
import android.content.Context;
import androidx.multidex.MultiDex;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author TW
 * @date 2020/7/29 8:59
 * @description
 * @mail 2278671454@qq.com
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
