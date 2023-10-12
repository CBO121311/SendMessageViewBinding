package com.example.sendmessageviewbinding;

import android.app.Application;
import android.util.Log;

/**
 * Esta clase sirve para comprobar los registros (Logcat) y saber como funciona la aplicación
 * @author Alejandro López
 * @version 1.0
 */
public class MessageApplication extends Application {
    public static final String TAG = "MessageApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "messageApplication -> onCreate()");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "messageApplication -> onTerminate()");
    }
}
