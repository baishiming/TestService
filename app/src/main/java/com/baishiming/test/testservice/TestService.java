package com.baishiming.test.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * @author bsm
 * @name TestService
 * @class name：com.baishiming.test.testservice
 * @class describe
 * @time 2019/10/30 10:41
 */
public class TestService extends Service {


    private static final String TAG = "myservice";
    private LocalBinder mbinder = new LocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind:" );
        return mbinder;
    }

    public class LocalBinder extends Binder {
        public TestService getServices(){
            return TestService.this;
        }
        public void start(){
            Log.e(TAG, "start:" );
        }
        public void end(){
            Log.e(TAG, "end:" );
        }
    }

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate:");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand:");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy:");
        super.onDestroy();
    }


    public  String myWay(){
        Log.e(TAG, "myway:hello world");
        return "hello world";
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind:");
        return super.onUnbind(intent);
    }

}
