package com.aaron.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private MyService mService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindService(new Intent(IMyAidlInterface.class.getName()), mConnection,
                Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection mConnection = new ServiceConnection()
    {
        public void onServiceConnected(ComponentName className, IBinder service)
        {
            Log.d("TAG", "onServiceConnected");
            mService = (MyService) IMyAidlInterface.Stub.asInterface((IBinder)service);
        }

        public void onServiceDisconnected(ComponentName className)
        {
            Log.d("TAG", "onServiceDisconnected");
            mService = null;
        }
    };

}
