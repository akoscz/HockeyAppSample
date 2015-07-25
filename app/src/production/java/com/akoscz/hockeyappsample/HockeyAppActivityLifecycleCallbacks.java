package com.akoscz.hockeyappsample;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * An empty implementation of ActivityLifecycleCallbacks for the production flavor of the app.
 */
public class HockeyAppActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        // no-op
    }

    @Override
    public void onActivityStarted(Activity activity) {
        // no-op
    }

    @Override
    public void onActivityResumed(Activity activity) {
        // no-op
    }

    @Override
    public void onActivityPaused(Activity activity) {
        // no-op
    }

    @Override
    public void onActivityStopped(Activity activity) {
        // no-op
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        // no-op
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        // no-op
    }
}
