package com.baishiming.test.testservice;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DemoActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "DemoActivity";
    private TestService services;

    private ServiceConnection conn;
    private Button startService;
    private Button stopService;
    private Button bindService;
    private Button unbindService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        startService = (Button) findViewById(R.id.startService);
        stopService = (Button) findViewById(R.id.stopService);

        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        bindService = (Button) findViewById(R.id.bindService);
        bindService.setOnClickListener(this);
        unbindService = (Button) findViewById(R.id.unbindService);
        unbindService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startService:
                Intent start = new Intent(this, TestService.class);
                startService(start);
                break;
            case R.id.stopService:
                Intent stop = new Intent(this, TestService.class);
                stopService(stop);
                break;
            case R.id.bindService:
                //绑定服务
                Intent intent = new Intent(this, TestService.class);
                bindService(intent,conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.unbindService:
                //解绑服务
                Intent intent1 = new Intent(this, TestService.class);
                unbindService(conn);
                break;
        }
    }


    /**
     * 里面主要是为了实现一个可以从service的回调接口
     */
    public void initData() {
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                TestService.LocalBinder binder = (TestService.LocalBinder) iBinder;
                binder.start();
                binder.end();
                services = binder.getServices();
                services.myWay();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                services = null;
                Log.e(TAG, "onServiceDisconnected:");
            }
        };
    }

}
