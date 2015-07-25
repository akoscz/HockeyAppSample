package com.akoscz.hockeyappsample;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.LoginManager;
import net.hockeyapp.android.Tracking;
import net.hockeyapp.android.UpdateManager;
import net.hockeyapp.android.UpdateManagerListener;

import java.util.Date;

/**
 * An implementation of ActivityLifecycleCallbacks used to hook up the HockeyApp into your application.
 */
public class HockeyAppActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    public void onActivityCreated(Activity activity, Bundle bundle) {

        // Filter out all activities except MainActivity.
        // We only want to register the LoginManager and UpdateManager in the MainActivity
        if (isMainActivity(activity)) {
            LoginManager.register(activity,
                    BuildConfig.HOCKEYAPP_ID,
                    BuildConfig.HOCKEYAPP_SECRET,
                    BuildConfig.HOCKEYAPP_LOGIN_MODE,
                    activity.getClass());
            LoginManager.verifyLogin(activity, activity.getIntent());

            try {
                // check if expire date exist. If it does not it will throw an exception
                BuildConfig.class.getField("HOCKEYAPP_EXPIRE_DATE");

                UpdateManager.register(activity, BuildConfig.HOCKEYAPP_ID,
                    new UpdateManagerListener() {
                        @Override
                        public Date getExpiryDate() {
                            Date expireDate = new Date(BuildConfig.HOCKEYAPP_EXPIRE_DATE);
                            return expireDate;
                        }
                    }, true);

            } catch (NoSuchFieldException ex) {
                // expiry date not configured
                Log.w(this.getClass().getSimpleName(), "HockeyApp Expire Date NOT configured.");
            }
        }
    }
    public void onActivityStarted(Activity activity) { /* no-op */ }

    public void onActivityResumed(Activity activity) {
        // Filter out all activities except MainActivity
        if (isMainActivity(activity)) {
            CrashManager.register(activity, BuildConfig.HOCKEYAPP_ID);
        }

        // we want to register for tracking for ALL non-hockeyapp activities
        if (BuildConfig.HOCKEYAPP_ENABLE_TRACKING && !isInHockeyAppPackage(activity)) {
            Tracking.startUsage(activity);
        }
    }

	public void onActivityPaused(Activity activity) {
        // Filter out all activities except MainActivity
        if (isMainActivity(activity)) {
            UpdateManager.unregister();
        }

        // we want to register for tracking for ALL non-hockeyapp activities
        if (BuildConfig.HOCKEYAPP_ENABLE_TRACKING && !isInHockeyAppPackage(activity)) {
            Tracking.stopUsage(activity);
        }
    }

    public void onActivityStopped(Activity activity) { /* no-op */ }

    public void onActivityDestroyed(Activity activity) { /* no-op */}

	public void onActivitySaveInstanceState(Activity activity, Bundle outState) { /* no-op */ }

    private static boolean isMainActivity(Object obj) {
        return obj.getClass() == com.akoscz.hockeyappsample.MainActivity.class;
    }

    private static boolean isInHockeyAppPackage(Object obj) {
        return obj.getClass().getPackage().getName().startsWith("net.hockeyapp.android");
    }
}
