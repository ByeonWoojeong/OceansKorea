package app.woojeong.oceanskorea;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.NotificationManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class ApplicationLifecycleHandler implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final String TAG = "LifecycleHandler";

    Context context;

    private boolean isInBackground = false;

    public final boolean isInBackground() {
        Log.i(TAG, " : isInBackground");
        return isInBackground;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Log.i(TAG, " : onActivityCreated");
        context = activity.getBaseContext();
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.i(TAG, " : onActivityStarted");
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.i(TAG, " : onActivityResumed");
        if (isInBackground) {
            isInBackground = false;
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(2554);

        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.i(TAG, " : onActivityPaused");
    }
 
    @Override
    public void onActivityStopped(Activity activity) {
        Log.i(TAG, " : onActivityStopped");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Log.i(TAG, " : onActivitySaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.i(TAG, " : onActivityDestroyed");
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        Log.i(TAG, " : onConfigurationChanged");
    }

    @Override
    public void onLowMemory() {
        Log.i(TAG, " : onLowMemory");
    }

    @Override
    public void onTrimMemory(int i) {
        Log.i(TAG, " : onTrimMemory");
        if (i == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            isInBackground = true;
        }
    }
}