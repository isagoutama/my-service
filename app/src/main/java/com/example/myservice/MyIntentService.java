package com.example.myservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {
    public static String EXTRA_DURATION = "extra_duration";
    public static final String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService() {
        super("DicodingIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            int duration = intent.getIntExtra(EXTRA_DURATION, 0);
            try {
                Log.d(TAG, "onHandleIntent: Selesai.....");
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
