package org.np.esn.esnnationalplatform;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class ESNApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Fabric.with(this, new Crashlytics());
        }
    }
}
