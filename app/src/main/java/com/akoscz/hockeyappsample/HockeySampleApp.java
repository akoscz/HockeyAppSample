package com.akoscz.hockeyappsample;

import android.app.Application;
import android.util.Log;

/**
 *  Your app's Application subclass.
 */
public class HockeySampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // If you plan to have an implementation of HockeyAppActivityLifecycleCallbacks in each productFlavor
        // then you simply register an instance of HockeyAppActivityLifecycleCallbacks with the application.
        registerActivityLifecycleCallbacks(new HockeyAppActivityLifecycleCallbacks());

        // Alternatively if you *DO NOT* want any hockey app related code in the production flavor
        // of your app, you can use reflection to instantiate HockeyAppActivityLifecycleCallbacks.
        // In other word, you will only have the HockeyAppActivityLifecycleCallbacks.java source file
        // in the 'hockey' source folder.
        // For example:
        /*
        if (BuildConfig.FLAVOR == "hockey") {
            try {
                ActivityLifecycleCallbacks activityLifecycleCallbacks = (ActivityLifecycleCallbacks)Class.forName("com.akoscz.hockeyappsample.HockeyAppActivityLifecycleCallbacks").newInstance();
                registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            } catch (Exception e) {
                Log.e(getClass().getSimpleName(), "HockeyAppActivityLifecycleCallbacks not found for '" + BuildConfig.FLAVOR + "' productFlavor");
            }
        }
        */
    }
}
