package ru.trueip.hhproject11;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static App mSelf;

    public static App self() {
        return mSelf;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSelf = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}